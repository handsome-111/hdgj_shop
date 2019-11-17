package com.hdgj.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 店铺商品
 * 
 * @author Administrator
 *
 */
@Document("shop_product")
public class ShopProduct {

	@Id
	private String itemid;
	private int istop;
	private List<String> imgs;
	private int status;
	@Field("item_desc")
	private String itemDesc;
	@Field("merchant_code")
	private String merchantcode;
	@DBRef
	private List<Cate> cates;
	private int stock;
	private double price;
	@Field("update_time")
	private Date updatetime;
	@Field("item_name")
	private String itemName;
	@Field("fx_fee_rate")
	private String fxFeeRate;
	@Field("thumb_imgs")
	private List<String> thumbImgs;
	@Field("seller_id")
	private String sellerId;
	@DBRef
	private List<Sku> skus;
	@Field("add_time")
	private Date addTime;
	
	public ShopProduct(){}
	

	//销量
	private int sold;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getIstop() {
		return istop;
	}
	public void setIstop(int istop) {
		this.istop = istop;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public List<Cate> getCates() {
		return cates;
	}
	public void setCates(List<Cate> cates) {
		this.cates = cates;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getMerchantcode() {
		return merchantcode;
	}
	public void setMerchantcode(String merchantcode) {
		this.merchantcode = merchantcode;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
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
	public List<String> getThumbImgs() {
		return thumbImgs;
	}
	public void setThumbImgs(List<String> thumbImgs) {
		this.thumbImgs = thumbImgs;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public List<Sku> getSkus() {
		return skus;
	}
	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	@Override
	public String toString() {
		return "ShopProduct [itemid=" + itemid + ", istop=" + istop + ", imgs=" + imgs + ", status=" + status
				+ ", itemDesc=" + itemDesc + ", merchantcode=" + merchantcode + ", cates=" + cates + ", stock=" + stock
				+ ", price=" + price + ", updatetime=" + updatetime + ", itemName=" + itemName + ", fxFeeRate="
				+ fxFeeRate + ", thumbImgs=" + thumbImgs + ", sellerId=" + sellerId + ", skus=" + skus + ", addTime="
				+ addTime + ", sold=" + sold + "]";
	}

}
