package com.hdgj.other.vd.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hdgj.entity.AttrValue;
import com.hdgj.entity.ModelAttr;
import com.hdgj.entity.Product;
import com.hdgj.entity.ProductDetail;
import com.hdgj.entity.ShopProduct;
import com.hdgj.entity.Sku;
import com.hdgj.entity.repository.AttrValueRepository;
import com.hdgj.entity.repository.ModelAttrRepository;
import com.hdgj.entity.repository.ProductDetailRepository;
import com.hdgj.entity.repository.ProductRepository;
import com.hdgj.entity.repository.ShopProductRepository;
import com.hdgj.entity.repository.SkuAttrRepository;
import com.hdgj.other.vd.api.ProductDetailService;
import com.hdgj.other.vd.api.VDService;
import com.weidian.open.sdk.exception.OpenException;

@Service
public class SyncVdService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private VDService vdService;

	@Autowired
	private SkuAttrRepository skuAttrResponse;

	@Autowired
	private ModelAttrRepository modelAttrRepository;

	@Autowired
	private AttrValueRepository attrValueRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductDetailRepository productDetailRepository;

	@Autowired
	private ProductDetailService productDetailService;
	
	@Autowired
	private ShopProductRepository shopProductRepository;
	
	/**
	 * 同步店铺商品分类
	 */
	public void syncCarts(){
		String response = null;
		try {
			response = vdService.weidianCateGetList(new Integer(1));
		} catch (OpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("response:" + response);
	}

	/**
	 * 同步商品的型号属性
	 */
	public void syncVdSkuAttr() {
		String response = "";
		try {
			response = vdService.vdianSkuAttrsGet();
		} catch (OpenException e) {
			e.printStackTrace();
		}
		JSONObject res = JSON.parseObject(response);
		String status = res.getJSONObject("status").getString("status_code");

		JSONArray attrList = res.getJSONObject("result").getJSONArray("attr_list");
		Iterator ite = attrList.iterator();

		while (ite.hasNext()) {
			// 型号属性对象
			JSONObject modelAttr = (JSONObject) ite.next();

			/**
			 * 同步属性值
			 */
			JSONArray attrValues = modelAttr.getJSONArray("attr_values");
			Iterator attrvIterator = attrValues.iterator();
			while (attrvIterator.hasNext()) {
				AttrValue attvObj = ((JSONObject) attrvIterator.next()).toJavaObject(AttrValue.class);
				Example<AttrValue> ex = Example.of(attvObj);

				String attrValue = attvObj.getAttrValue();
				Update update = new Update();
				update.set("attr_id", attvObj.getAttrId());
				update.set("attr_value", attrValue);
				mongoTemplate.upsert(Query.query(Criteria.where("attr_id").is(attvObj.getAttrId())), update,
						AttrValue.class);
			}

			//System.out.println("attr_values:" + attrValues.toJSONString());

			/**
			 * 同步属性型号
			 */
			String attrTitle = modelAttr.getString("attr_title");
			Query query = Query.query(Criteria.where("attr_title").in(attrTitle));
			Update update = new Update();
			update.set("attr_title", attrTitle);
			update.set("attr_values", attrValues.toJavaList(AttrValue.class));
			mongoTemplate.upsert(query, update, ModelAttr.class);
		}

		//List<ModelAttr> mas = mongoTemplate.findAll(ModelAttr.class);
		//List<AttrValue> avs = mongoTemplate.findAll(AttrValue.class);
		//System.out.println("mas:" + mas);
		//System.out.println("avs:" + avs);
	}

	/**
	 * 同步商品详情和商品(product_detail,product,SKU)
	 */
	public void syncVdProductDetail() throws Exception {
		/**
		 * 获取分页和总数
		 */
		long count = productRepository.count();
		long page = this.getTotalPage(30, count);
		
		/**
		 * 分页同步商品详情,每次存储30个商品,防止内存溢出
		 */
		for (int i = 0; i <= page; i++) {
			// 读取所有的商品ID
			List<JSONObject> itemIds = shopProductRepository.findAllBy(PageRequest.of(i, 30));

			List<String> ids = new ArrayList<String>();
			for (JSONObject id : itemIds) {
				ids.add(id.getString("_id"));
			}

			/**
			 * 调用微店API获取所有的商品
			 */
			JSONArray items = vdService.weidianGetItems(ids, "1").getJSONArray("result");
			//System.out.println("items:" + items);
			
			if(items == null){
				break;
			}
						
			Iterator ite = items.iterator();
			
			List<Product> resProducts = new ArrayList<Product>();


			/**
			 * 迭代获取所有的商品详情
			 */
			while (ite.hasNext()) {
				JSONObject item = (JSONObject) ite.next();
				// 调用api获取的的商品详情
				List<ProductDetail> resDetails = item.getJSONArray("item_detail").toJavaList(ProductDetail.class);

				List<Sku> resSkus = item.getJSONArray("sku").toJavaList(Sku.class);
				skuAttrResponse.saveAll(resSkus);
				
				
				//List<ProductDetail> resDetails = item.getItem_detail();
				
				// 从本地数据库查询的商品详情
				List<ProductDetail> findDetails = productDetailRepository.findByItemId(item.getString("id"));
				
				for (ProductDetail pd : resDetails) {
					pd.setItemId(item.getString("id"));
				}

				/**
				 * 如果不相等，则同步，先删除再保存
				 */
				if (!resDetails.equals(findDetails)) {
					productDetailService.delAndSave(item.getString("id"), resDetails);
					//productDetailService.delAndSave(item.getId(), resDetails);
				}
				
				
				item.remove("item_detail");
				Product product = item.toJavaObject(Product.class);
				product.setItemDetail(resDetails);
				resProducts.add(product);
			}
			
			
			//List<Product> resProducts = items.toJavaList(Product.class);
			productRepository.saveAll(resProducts);
		}
	}

	/**
	 * 同步微店商品(document:shopProduct)
	 */
	public String syncVdProduct() throws Exception {
		int countItem = vdService.getCountByItemList();
		int pageSize = 30;
		long totalPage = this.getTotalPage(pageSize, countItem);

		for (int i = 1; i <= totalPage; i++) {
			String response = vdService.vdianItemListGet(i, 1, pageSize, null, 1, null);
			JSONObject res = JSONObject.parseObject(response);
			int status = res.getJSONObject("status").getInteger("status_code");

			if (status != 0) {
				return res.getJSONObject("status").getString("status_reason");
			}

			/**
			 * 获取所有的商品
			 */ 
			//List<Product> items = res.getJSONObject("result").getJSONArray("items").toJavaList(Product.class);
			List<ShopProduct> items = res.getJSONObject("result").getJSONArray("items").toJavaList(ShopProduct.class);
			//System.out.println("微点商品shopProduct:" + res.getJSONObject("result").getJSONArray("items"));
			shopProductRepository.saveAll(items);
			//productRepository.saveAll(items);
		}

		return "商品同步完成";
	}

	/**
	 * 获取总页数
	 * 
	 * @param pageSize
	 *            页面大小
	 * @param count
	 *            总的Item
	 * @return
	 */
	public long getTotalPage(long pageSize, long count) {
		long totalPage = 1;

		if (count == 0) {
			return totalPage;
		}

		if (count % pageSize == 0) {
			totalPage = count / pageSize;
		} else {
			totalPage = count / pageSize + 1;
		}
		return totalPage;
	}

	public void test2() {
		String response = "";
		try {
			response = vdService.vdianSkuAttrsGet();
		} catch (OpenException e) {
			e.printStackTrace();
		}
		JSONObject res = JSON.parseObject(response);
		String status = res.getJSONObject("status").getString("status_code");

		List<ModelAttr> mas = res.getJSONObject("result").getJSONArray("attr_list").toJavaList(ModelAttr.class);

		Criteria c = new Criteria();
		c.where("username").is("1040978586").and("password").is("13379959770");
		mongoTemplate.find(Query.query(c), ModelAttr.class);

	}

	public void test3() {
		ModelAttr m = new ModelAttr();
		m.setAttrTitle("120克/瓶");

		Example<ModelAttr> am = Example.of(m);
		// Optional ms = modelAttrRepository.findOne(am);
		// System.out.println(ms);
	}

	public void test4() {
		String response = "";
		try {
			response = vdService.vdianSkuAttrsGet();
		} catch (OpenException e) {
			e.printStackTrace();
		}
		JSONObject res = JSON.parseObject(response);
		String status = res.getJSONObject("status").getString("status_code");

		List<ModelAttr> mas = res.getJSONObject("result").getJSONArray("attr_list").toJavaList(ModelAttr.class);

		List<AttrValue> attvs = new ArrayList<AttrValue>();
		Iterator<ModelAttr> ite = mas.iterator();
		while (ite.hasNext()) {
			ModelAttr modelAttr = ite.next();
			attvs.addAll(modelAttr.getAttrValues());
		}

		/*
		 * List<String> titles = new ArrayList<String>(); List<List<AttrValue>>
		 * attrVs = new ArrayList<List<AttrValue>>(); Iterator<Object> ite =
		 * attrList.iterator();
		 * 
		 * while(ite.hasNext()){ ModelAttr obj =
		 * ((JSONObject)ite.next()).toJavaObject(ModelAttr.class);
		 * titles.add(obj.getAttrTitle()); attrVs.add(obj.getattrValues()); }
		 * 
		 * Criteria crit = new Criteria().where("attr_title").in(titles); Query
		 * query = Query.query(crit);
		 * 
		 * mongoTemplate.updateMulti(query, , ModelAttr.class);
		 */
		modelAttrRepository.saveAll(mas);
		attrValueRepository.saveAll(attvs);
		System.out.println(modelAttrRepository.findAll());
	}
}
