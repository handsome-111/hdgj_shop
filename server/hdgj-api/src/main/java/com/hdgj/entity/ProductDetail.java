package com.hdgj.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.fastjson.JSONObject;

/**
 * 商品详情
 * @author Administrator
 *
 */
@Document("product_detail")
public class ProductDetail {
	@Id
	private String id;
	
	@Field("item_id")
	//商品id
	private String itemId;
	
	@Field
	//详情文本
	private String text;
	
	@Field
	//type =1 文字模块,type =2 图片, type =3 商品模块，type=4视频模块
	private Number type;
	
	@Field
	//记录某一个detail对象在detail中的位置
	private Number pos;
	
	@Field
	//首页地址
	private String faceurl;
	
	@Field("video_type")
	//1表示腾迅视频，2表示美拍视频(type=4填写此字段)
	private String videoType;
	
	@Field
	//图片的url（type=2填写此字段）
	private String url;

	
	@Override
	public boolean equals(Object obj) {
		JSONObject objJson = (JSONObject) JSONObject.toJSON(obj);
		JSONObject thisJson = (JSONObject) JSONObject.toJSON(this);
		
		Object id = null;
		
		Object id1 = objJson.get("id");
		Object id2 = thisJson.get("id");
		
		if(id1 != null ){
			id = id1;
		}

		if(id2 != null){
			id = id2;
		}
		
		thisJson.remove("id");
		objJson.remove("id");
		
		boolean boo = objJson.equals(thisJson);
		this.setId((String) id);

		return boo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Number getType() {
		return type;
	}

	public void setType(Number type) {
		this.type = type;
	}

	public Number getPos() {
		return pos;
	}

	public void setPos(Number pos) {
		this.pos = pos;
	}

	public String getFaceurl() {
		return faceurl;
	}

	public void setFaceurl(String faceurl) {
		this.faceurl = faceurl;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "ProductDetail [itemId=" + itemId + ", text=" + text + ", type=" + type + ", pos=" + pos
				+ ", faceurl=" + faceurl + ", videoType=" + videoType + ", url=" + url + "]";
	}


	
}
