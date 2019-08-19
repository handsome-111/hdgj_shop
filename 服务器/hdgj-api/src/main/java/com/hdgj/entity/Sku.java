package com.hdgj.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 商品型号属性，存储于Mongodb
 */
@Document(collection = "sku_attr")
public class Sku implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	
	//sku名称
	@Field
	private String title;
	
	//库存量
	@Field
	private String stock;
	
	//商品型号编码
	@Field("sku_merchant_code")
	private String skuMerchantCode;
	
	//多级SKU属性id
	@Field("attr_ids")
	private String attrIds;
	
	//价格
	@Field
	private String price;
	
	private Integer status;
	
	@Field("csku_id")
	private String cskuId;
	
	
	private String img;
	
	@Field("dur_time")
	private String durTime;
	
	@Field("item_id")
	/**
	 * 商品ID
	 */
	private String itemId;
	
	@Field("sup_price")
	private String supPrice;
	
	@Field("buy_stock")
	private Integer buyStock;
	
	@Field("sup_id")
	private String supId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getSkuMerchantCode() {
		return skuMerchantCode;
	}

	public void setSkuMerchantCode(String skuMerchantCode) {
		this.skuMerchantCode = skuMerchantCode;
	}

	public String getAttrIds() {
		return attrIds;
	}

	public void setAttrIds(String attrIds) {
		this.attrIds = attrIds;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCskuId() {
		return cskuId;
	}

	public void setCskuId(String cskuId) {
		this.cskuId = cskuId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSupPrice() {
		return supPrice;
	}

	public void setSupPrice(String supPrice) {
		this.supPrice = supPrice;
	}

	public Integer getBuyStock() {
		return buyStock;
	}

	public void setBuyStock(Integer buyStock) {
		this.buyStock = buyStock;
	}

	public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public String getDurTime() {
		return durTime;
	}

	public void setDurTime(String durTime) {
		this.durTime = durTime;
	}

	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", stock=" + stock + ", skuMerchantCode=" + skuMerchantCode
				+ ", attrIds=" + attrIds + ", price=" + price + ", status=" + status + ", cskuId=" + cskuId + ", img="
				+ img + ", durTime=" + durTime + ", itemId=" + itemId + ", supPrice=" + supPrice + ", buyStock="
				+ buyStock + ", supId=" + supId + "]";
	}

	
	
	
	
}
