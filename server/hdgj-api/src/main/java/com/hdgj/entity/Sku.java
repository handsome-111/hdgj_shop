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
	//商品型号的ID
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
	
	//多级SKU属性id(这里的id和title中的名称对应) 764651-L, 764647-蓝色
	@Field("attr_ids")
	private String attrIds;
	
	@Field
	//价格
	private String price;
		
	@Field("csku_id")
	private String cskuId;
	
	//商品图URL
	private String img;
	

	
	@Field("item_id")
	 //商品ID
	private String itemId;
	
	
	
	@Field("buy_stock")
	//可以购买的库存数
	private Integer buyStock;
	
	//销量
	private String sold;
	
	//商品状态 1: 正常 2: 下架 3:删除
	private Number status;
	
	
	/**
	 * 未知属性
	 * @return
	 */
	private String features;
	
	@Field("sup_id")
	private Number supId;
	
	@Field("stock_biz")
	private Number stockBiz;
	
	@Field("stock_flag")
	private Number stockFlag;
	
	@Field("stock_seller_id")
	private Number stockSellerId;
	
	@Field("stock_address")
	private String stockAddress;
	
	@Field("dur_time")
	private String durTime;
	
	@Field("sup_price")
	private Number supPrice;
	
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

	
	public Integer getBuyStock() {
		return buyStock;
	}

	public void setBuyStock(Integer buyStock) {
		this.buyStock = buyStock;
	}

	
	public String getDurTime() {
		return durTime;
	}

	public void setDurTime(String durTime) {
		this.durTime = durTime;
	}

	public Number getSupPrice() {
		return supPrice;
	}

	public void setSupPrice(Number supPrice) {
		this.supPrice = supPrice;
	}

	public Number getSupId() {
		return supId;
	}

	public void setSupId(Number supId) {
		this.supId = supId;
	}

	public String getSold() {
		return sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}

	public Number getStockSellerId() {
		return stockSellerId;
	}

	public void setStockSellerId(Number stockSellerId) {
		this.stockSellerId = stockSellerId;
	}

	public String getStockAddress() {
		return stockAddress;
	}

	public void setStockAddress(String stockAddress) {
		this.stockAddress = stockAddress;
	}

	public Number getStatus() {
		return status;
	}

	public void setStatus(Number status) {
		this.status = status;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public Number getStockBiz() {
		return stockBiz;
	}

	public void setStockBiz(Number stockBiz) {
		this.stockBiz = stockBiz;
	}

	public Number getStockFlag() {
		return stockFlag;
	}

	public void setStockFlag(Number stockFlag) {
		this.stockFlag = stockFlag;
	}

	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", stock=" + stock + ", skuMerchantCode=" + skuMerchantCode
				+ ", attrIds=" + attrIds + ", price=" + price + ", cskuId=" + cskuId + ", img=" + img + ", itemId="
				+ itemId + ", buyStock=" + buyStock + ", sold=" + sold + ", status=" + status + ", features=" + features
				+ ", supId=" + supId + ", stockBiz=" + stockBiz + ", stockFlag=" + stockFlag + ", stockSellerId="
				+ stockSellerId + ", stockAddress=" + stockAddress + ", durTime=" + durTime + ", supPrice=" + supPrice
				+ "]";
	}

	
	
	
	
	
	
	
}
