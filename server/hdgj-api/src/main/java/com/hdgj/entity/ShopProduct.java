package com.hdgj.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	private String item_desc;
	private String merchant_code;
	private List<Cate> cates;
	private int stock;
	private String price;
	private Date update_time;
	private String item_name;
	private String fx_fee_rate;
	private List<String> thumb_imgs;
	private String seller_id;
	private List<String> skus;
	private Date add_time;
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
	public String getItem_desc() {
		return item_desc;
	}
	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}
	public String getMerchant_code() {
		return merchant_code;
	}
	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
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
	public List<String> getThumb_imgs() {
		return thumb_imgs;
	}
	public void setThumb_imgs(List<String> thumb_imgs) {
		this.thumb_imgs = thumb_imgs;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public List<String> getSkus() {
		return skus;
	}
	public void setSkus(List<String> skus) {
		this.skus = skus;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}

}
