package com.hdgj.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Auto-generated: 2019-09-16 1:8:36
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Document
public class Sku3 {
	@Id
    private long id;
    private String title;
    private String sku_merchant_code;
    private String price;
    private int stock;
    private int status;
    private int buy_stock;
    private long item_id;
    private String img;
    private String attr_ids;
    private int sold;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setSku_merchant_code(String sku_merchant_code) {
         this.sku_merchant_code = sku_merchant_code;
     }
     public String getSku_merchant_code() {
         return sku_merchant_code;
     }

    public void setPrice(String price) {
         this.price = price;
     }
     public String getPrice() {
         return price;
     }

    public void setStock(int stock) {
         this.stock = stock;
     }
     public int getStock() {
         return stock;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setBuy_stock(int buy_stock) {
         this.buy_stock = buy_stock;
     }
     public int getBuy_stock() {
         return buy_stock;
     }

    public void setItem_id(long item_id) {
         this.item_id = item_id;
     }
     public long getItem_id() {
         return item_id;
     }

    public void setImg(String img) {
         this.img = img;
     }
     public String getImg() {
         return img;
     }

    public void setAttr_ids(String attr_ids) {
         this.attr_ids = attr_ids;
     }
     public String getAttr_ids() {
         return attr_ids;
     }

    public void setSold(int sold) {
         this.sold = sold;
     }
     public int getSold() {
         return sold;
     }

}