package com.hdgj.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * 商品，存储于Mongodb
 * @author Administrator
 *
 */
@Document("product")
public class Product {
	
	@Id
	private Number id;
	
	@Field
	//商品id
	private String itemid;
	@Field
	//创建时间
	private String createdTime;
	
	@Field
	//更新时间
	private String updated_time;
	
	@Field
	//商品描述
	private String item_desc;
	
	@Field
	//商品名称
	private String item_name;
	
	@Field
	//分销分成比例
	private String fx_fee_rate;
	
	@Field
	//卖家Id,目前没用的字段
	private String seller_id;
	
	@Field
	//商品编号
	private String merchant_code;
	
	@Field
	//商品销量
	private Number sold;
	
	@Field
	//商品状态，商品状态（onsale ：销售中 instock：已下架 delete：已删除）
	private String status;
	
	@Field
	//库存量
	private Number stock;
	
	@Field
	//偏远地区是否包邮：1不包邮，0包邮
	private Number remote_free_delivery;
	
	@Field
	//是否包邮：0不包邮，1包邮
	private Number free_delivery;
	
	@Field
	//商品价格,在Mongodb中可以排序
	private String price;	
	
	@Field
	//商品图片描述
	private List titles;
	
	@Field
	//图片略缩图，缩小后的
	private List thumb_imgs;
	
	@Field
	//商品图片(展示商品的图片/视频)
	private List imgs;
	
	@DBRef
	//skus
	private List<Sku> skus;
	
	@DBRef
	//商品所属分类
	private List<Cate> cates;

	public Product(Number id, String itemid, String createdTime, String updated_time, String item_desc,
			String item_name, String fx_fee_rate, String seller_id, String merchant_code, Number sold, String status,
			Number stock, Number remote_free_delivery, Number free_delivery, String price, List titles, List thumb_imgs,
			List imgs, List<Sku> skus, List<Cate> cates) {
		super();
		this.id = id;
		this.itemid = itemid;
		this.createdTime = createdTime;
		this.updated_time = updated_time;
		this.item_desc = item_desc;
		this.item_name = item_name;
		this.fx_fee_rate = fx_fee_rate;
		this.seller_id = seller_id;
		this.merchant_code = merchant_code;
		this.sold = sold;
		this.status = status;
		this.stock = stock;
		this.remote_free_delivery = remote_free_delivery;
		this.free_delivery = free_delivery;
		this.price = price;
		this.titles = titles;
		this.thumb_imgs = thumb_imgs;
		this.imgs = imgs;
		this.skus = skus;
		this.cates = cates;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}

	public List<Cate> getCates() {
		return cates;
	}

	public void setCates(List<Cate> cates) {
		this.cates = cates;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getFx_fee_rate() {
		return fx_fee_rate;
	}

	public void setFx_fee_rate(String fx_fee_rate) {
		this.fx_fee_rate = fx_fee_rate;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getMerchant_code() {
		return merchant_code;
	}

	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}

	public Number getSold() {
		return sold;
	}

	public void setSold(Number sold) {
		this.sold = sold;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Number getStock() {
		return stock;
	}

	public void setStock(Number stock) {
		this.stock = stock;
	}

	public Number getRemote_free_delivery() {
		return remote_free_delivery;
	}

	public void setRemote_free_delivery(Number remote_free_delivery) {
		this.remote_free_delivery = remote_free_delivery;
	}

	public Number getFree_delivery() {
		return free_delivery;
	}

	public void setFree_delivery(Number free_delivery) {
		this.free_delivery = free_delivery;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List getTitles() {
		return titles;
	}

	public void setTitles(List titles) {
		this.titles = titles;
	}

	public List getThumb_imgs() {
		return thumb_imgs;
	}

	public void setThumb_imgs(List thumb_imgs) {
		this.thumb_imgs = thumb_imgs;
	}

	public List getImgs() {
		return imgs;
	}

	public void setImgs(List imgs) {
		this.imgs = imgs;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", itemid=" + itemid + ", createdTime=" + createdTime + ", updated_time="
				+ updated_time + ", item_desc=" + item_desc + ", item_name=" + item_name + ", fx_fee_rate="
				+ fx_fee_rate + ", seller_id=" + seller_id + ", merchant_code=" + merchant_code + ", sold=" + sold
				+ ", status=" + status + ", stock=" + stock + ", remote_free_delivery=" + remote_free_delivery
				+ ", free_delivery=" + free_delivery + ", price=" + price + ", titles=" + titles + ", thumb_imgs="
				+ thumb_imgs + ", imgs=" + imgs + ", skus=" + skus + ", cates=" + cates + "]";
	}
	
	
}








