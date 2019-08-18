package com.hdgj.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

public class A {
	private List<String> imgs;
	
	@Id
	//商品id
	private String itemid;
	@Field("created_time")
	//创建时间
	private String createdTime;
	
	@Field("updated_time")
	//更新时间
	private String updatedTime;
	
	@Field("item_desc")
	//商品描述
	private String itemDesc;
	
	@Field("item_name")
	//商品名称
	private String itemName;
	
	@Field("fx_fee_rate")
	//分销分成比例
	private String fxFeeRate;
	
	@Field("seller_id")
	//卖家Id,目前没用的字段
	private String sellerId;
	
	@Field("merchant_code")
	//商品编号
	private String merchantCode;
	
	@Field
	//商品销量
	private Number sold;
	
	@Field
	//商品状态，商品状态（onsale ：销售中 instock：已下架 delete：已删除）
	private String status;
	
	@Field
	//库存量
	private Number stock;
	
	@Field("remote_free_delivery")
	//偏远地区是否包邮：1不包邮，0包邮
	private Number remotefreedelivery;
	
	@Field("free_delivery")
	//是否包邮：0不包邮，1包邮
	private Number freeDelivery;
	
	@Field
	//商品价格,在Mongodb中可以排序
	private String price;	
	
	@Field
	//商品图片描述
	private List<String> titles;
	
	@Field("thumb_imgs")
	//图片略缩图，缩小后的
	private List<String> thumbImgs;
	
	
	@DBRef
	//skus
	private List<Sku> skus;

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
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

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getFxFeeRate() {
		return fxFeeRate;
	}

	public void setFxFeeRate(String fxFeeRate) {
		this.fxFeeRate = fxFeeRate;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
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

	public Number getRemotefreedelivery() {
		return remotefreedelivery;
	}

	public void setRemotefreedelivery(Number remotefreedelivery) {
		this.remotefreedelivery = remotefreedelivery;
	}

	public Number getFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(Number freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<String> getThumbImgs() {
		return thumbImgs;
	}

	public void setThumbImgs(List<String> thumbImgs) {
		this.thumbImgs = thumbImgs;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}

	@Override
	public String toString() {
		return "A [imgs=" + imgs + ", itemId=" + itemid + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", itemDesc=" + itemDesc + ", itemName=" + itemName + ", fxFeeRate=" + fxFeeRate
				+ ", sellerId=" + sellerId + ", merchantCode=" + merchantCode + ", sold=" + sold + ", status=" + status
				+ ", stock=" + stock + ", remotefreedelivery=" + remotefreedelivery + ", freeDelivery=" + freeDelivery
				+ ", price=" + price + ", titles=" + titles + ", thumbImgs=" + thumbImgs + ", skus=" + skus + "]";
	}


	
}
