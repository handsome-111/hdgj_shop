package com.hdgj.other.vd.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.weidian.open.sdk.exception.OpenException;
import com.weidian.open.sdk.http.Param;
import com.weidian.open.sdk.util.JsonUtils;
import com.weidian.open.sdk.util.SystemConfig;

@Service
public class VDService extends BaseService{
	/**
	 * 获取全店商品
	 * @param page_num 页码，从1开始
	 * @param orderby	排序方式(默认值1)：1.推荐商品排前面、添加时间降序，2.只查询已售罄商品、按商品添加时间降序，3.按商品销量降序 ，4.按商品销量升序， 5.按商品库存降序 ，6. 按商品库存升序
	 * @param page_size	单页条数，默认值30，最大50条
	 * @param update_end	商品更新时间段的结束时间，如：2014-11-1216:36:08精确到秒
	 * @param status	status=1或不传为在架商品(不包含供货商货源)，status=2为下架商品,4表示下架和在架商品,10供货商货源
	 * @param update_start  商品更新时间段的开始时
	 * @return
	 * @throws OpenException
	 */
	public String vdianItemListGet(Number page_num, Number orderby, Number page_size, String update_end, Number status, String update_start) throws OpenException {
	    Map< String, Object> map = new HashMap< String, Object>();
	    map.put("page_num", page_num);
	    map.put("orderby", orderby);
	    map.put("page_size", page_size);
	    map.put("update_end", update_end);
	    map.put("status", status);
	    map.put("update_start", update_start);
	    super.removeNullValue(map);
	    return vdClient.executePostForString(SystemConfig.API_URL_FOR_POST,
	            new Param("public", buildPublicValue("vdian.item.list.get", "1.1")),
	            new Param("param", JsonUtils.toJson(map)));
	}
	/**
	 * 获取全店商品列表总数
	 * @return
	 */
	public int getCountByItemList()throws Exception{
		int totalNum = 0;
		String response = this.vdianItemListGet(1, 1, 30, null, 0, null);
		JSONObject res = JSONObject.parseObject(response);
		int status =  res.getJSONObject("status").getInteger("status_code");
		if(status == 0){
			totalNum = res.getJSONObject("result").getInteger("total_num");
		}
		return totalNum;    
	}
	
	/**
	 * 获取型号属性列表)
	 * @return
	 * @throws OpenException
	 */
	public String vdianSkuAttrsGet() throws OpenException {
	    Map< String, Object> map = new HashMap< String, Object>();
	    return vdClient.executePostForString(SystemConfig.API_URL_FOR_POST,
	            new Param(SystemConfig.PUBLIC_PARAM, buildPublicValue("vdian.sku.attrs.get", "1.0")),
	            new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
	}
	
	/**
	 * 获取商品详情
	 * @param item_id 商品ID
	 * @return
	 * @throws OpenException
	 */
	public JSONObject vdianItemGetItemDetail(Number item_id) throws OpenException {
	    Map< String, Object> map = new HashMap< String, Object>();
	    map.put("item_id", item_id);
	    super.removeNullValue(map);
	    String res = vdClient.executePostForString(SystemConfig.API_URL_FOR_POST,
	            new Param(SystemConfig.PUBLIC_PARAM, buildPublicValue("vdian.item.getItemDetail", "1.0")),
	            new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
	    return JSONObject.parseObject(res);
	}
	
	
	/**
	 * 获取多个商品
	 * @param  (1) ids: 商品ID，多个商品ID以逗号隔开，最多支持100个商品id
	 * @param need_idno		是否返回清关标志，1是，0否
	 * @return
	 * @throws OpenException
	 */
	public JSONObject weidianGetItems(List<String> itemIds, String need_idno) throws OpenException {
		StringBuilder ids = new StringBuilder();
		for(String id : itemIds){
			ids.append(id);
			ids.append(",");
		}
		
		if(ids.length() > 0){
			ids.deleteCharAt(ids.length() -1 );
		}
				
	    Map<String, Object> map = new HashMap< String, Object>();
	    map.put("ids", ids);
	    map.put("need_idno", need_idno);
	    super.removeNullValue(map);
	    String res = vdClient.executePostForString(SystemConfig.API_URL_FOR_POST,
	            new Param(SystemConfig.PUBLIC_PARAM, buildPublicValue("weidian.get.items", "1.1")),
	            new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
	    return JSONObject.parseObject(res);
	}
	/**
	 * 获取全店商品分类
	 * @param showNoCate 是否显示“未分类”(0代表不显示，1代表显示默认的情况为0)
	 * @return
	 * @throws OpenException
	 * 请求示例：https://api.vdian.com/api?param={"showNoCate":"0"}&public={"method":"weidian.cate.get.list","access_token":"94b8b8dd81f757f8fc2e174bf45fb5f40004259179","version":"1.0"}
	 */
	public JSONObject weidianCateGetList(/*Number showNoCate*/) throws OpenException {
	    Map< String, Object> map = new HashMap< String, Object>();
	    //map.put("showNoCate", showNoCate);
	    super.removeNullValue(map);
	    
	    String res = vdClient.executePostForString(SystemConfig.API_URL_FOR_POST,
	            new Param(SystemConfig.PUBLIC_PARAM, buildPublicValue("weidian.cate.get.list", "1.0")),
	            new Param(SystemConfig.BIZ_PARAM, JsonUtils.toJson(map)));
	    return JSONObject.parseObject(res);
	}
}
