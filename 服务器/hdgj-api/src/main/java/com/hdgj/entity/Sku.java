package com.hdgj.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
	@Field
	private Integer sku_merchant_code;
	
	//多级SKU属性id
	@DBRef
	private List<AttrValue> attr_ids;
	
	//价格
	@Field
	private String price;
	
	private Integer status;
	
	@DBRef
	/**
	 * 商品ID
	 */
	private Product product;
	
	
	public Sku(String id, String title, String stock, Integer sku_merchant_code, List<AttrValue> attr_ids,
			String price) {
		super();
		this.id = id;
		this.title = title;
		this.stock = stock;
		this.sku_merchant_code = sku_merchant_code;
		this.attr_ids = attr_ids;
		this.price = price;
	}
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
	public Integer getSku_merchant_code() {
		return sku_merchant_code;
	}
	public void setSku_merchant_code(Integer sku_merchant_code) {
		this.sku_merchant_code = sku_merchant_code;
	}
	
	public List<AttrValue> getAttr_ids() {
		return attr_ids;
	}
	public void setAttr_ids(List<AttrValue> attr_ids) {
		this.attr_ids = attr_ids;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Sku [id=" + id + ", title=" + title + ", stock=" + stock + ", sku_merchant_code=" + sku_merchant_code
				+ ", attr_ids=" + attr_ids + ", price=" + price + "]";
	}
	
}
