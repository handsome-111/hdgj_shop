package com.hdgj.entity;

/**
  * Copyright 2019 bejson.com 
  */
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.JSONObject;

/**
 * Auto-generated: 2019-09-16 1:16:25
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Document("product")
public class Product22 {
	@Id
    private String id;
    private String high_point_price;
    private String img_head;
    private String low_point_price;
    private Date edit_time;
    private int sup_price;
    private List<ProductDetail> item_detail;
    private String merchant_code;
    private long bg_cate_id;
    private String high_point;
    private int sup_id;
    private int stock;
    private String service_flag;
    private List<String> full_imgs;
    private String future_sold_time;
    private int is_only_for_buyer;
    private String sold;
    private String is_need_idno;
    private int is_tax_rate;
    private String item_comment;
    private int status;
    private int is_cvs_item;
    private String flag_bin;
    private String point_price;
    @DBRef
    private List<Sku3> sku;
    private String high_price;
    private int is_point_price;
    private int is_future_sold;
    private String flag;
    private String price;
    private Date update_time;
    private int spu_id;
    private String item_name;
    private String low_point;
    private int buy_stock;
    private String low_price;
    private List<String> titles;
    private long seller_id;
    private Date add_time;
    private int purchase_fee;
    private int is_wzx_sup_item;
    private String tax_rate;
    
    @Override
    public boolean equals(Object obj) {
    	JSONObject objJson = (JSONObject) JSONObject.toJSON(obj);
		JSONObject thisJson = (JSONObject) JSONObject.toJSON(this);
    	return objJson.equals(thisJson);
    }
    public void setHigh_point_price(String high_point_price) {
         this.high_point_price = high_point_price;
     }
     public String getHigh_point_price() {
         return high_point_price;
     }

    public void setImg_head(String img_head) {
         this.img_head = img_head;
     }
     public String getImg_head() {
         return img_head;
     }

    public void setLow_point_price(String low_point_price) {
         this.low_point_price = low_point_price;
     }
     public String getLow_point_price() {
         return low_point_price;
     }

    public void setEdit_time(Date edit_time) {
         this.edit_time = edit_time;
     }
     public Date getEdit_time() {
         return edit_time;
     }

    public void setSup_price(int sup_price) {
         this.sup_price = sup_price;
     }
     public int getSup_price() {
         return sup_price;
     }

    public void setItem_detail(List<ProductDetail> item_detail) {
         this.item_detail = item_detail;
     }
     public List<ProductDetail> getItem_detail() {
         return item_detail;
     }

    public void setMerchant_code(String merchant_code) {
         this.merchant_code = merchant_code;
     }
     public String getMerchant_code() {
         return merchant_code;
     }

    public void setBg_cate_id(long bg_cate_id) {
         this.bg_cate_id = bg_cate_id;
     }
     public long getBg_cate_id() {
         return bg_cate_id;
     }

    public void setHigh_point(String high_point) {
         this.high_point = high_point;
     }
     public String getHigh_point() {
         return high_point;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setSup_id(int sup_id) {
         this.sup_id = sup_id;
     }
     public int getSup_id() {
         return sup_id;
     }

    public void setStock(int stock) {
         this.stock = stock;
     }
     public int getStock() {
         return stock;
     }

    public void setService_flag(String service_flag) {
         this.service_flag = service_flag;
     }
     public String getService_flag() {
         return service_flag;
     }

    public void setFull_imgs(List<String> full_imgs) {
         this.full_imgs = full_imgs;
     }
     public List<String> getFull_imgs() {
         return full_imgs;
     }

    public void setFuture_sold_time(String future_sold_time) {
         this.future_sold_time = future_sold_time;
     }
     public String getFuture_sold_time() {
         return future_sold_time;
     }

    public void setIs_only_for_buyer(int is_only_for_buyer) {
         this.is_only_for_buyer = is_only_for_buyer;
     }
     public int getIs_only_for_buyer() {
         return is_only_for_buyer;
     }

    public void setSold(String sold) {
         this.sold = sold;
     }
     public String getSold() {
         return sold;
     }

    public void setIs_need_idno(String is_need_idno) {
         this.is_need_idno = is_need_idno;
     }
     public String getIs_need_idno() {
         return is_need_idno;
     }

    public void setIs_tax_rate(int is_tax_rate) {
         this.is_tax_rate = is_tax_rate;
     }
     public int getIs_tax_rate() {
         return is_tax_rate;
     }

    public void setItem_comment(String item_comment) {
         this.item_comment = item_comment;
     }
     public String getItem_comment() {
         return item_comment;
     }

    public void setStatus(int status) {
         this.status = status;
     }
     public int getStatus() {
         return status;
     }

    public void setIs_cvs_item(int is_cvs_item) {
         this.is_cvs_item = is_cvs_item;
     }
     public int getIs_cvs_item() {
         return is_cvs_item;
     }

    public void setFlag_bin(String flag_bin) {
         this.flag_bin = flag_bin;
     }
     public String getFlag_bin() {
         return flag_bin;
     }

    public void setPoint_price(String point_price) {
         this.point_price = point_price;
     }
     public String getPoint_price() {
         return point_price;
     }

    public void setSku(List<Sku3> sku) {
         this.sku = sku;
     }
     public List<Sku3> getSku() {
         return sku;
     }

    public void setHigh_price(String high_price) {
         this.high_price = high_price;
     }
     public String getHigh_price() {
         return high_price;
     }

    public void setIs_point_price(int is_point_price) {
         this.is_point_price = is_point_price;
     }
     public int getIs_point_price() {
         return is_point_price;
     }

    public void setIs_future_sold(int is_future_sold) {
         this.is_future_sold = is_future_sold;
     }
     public int getIs_future_sold() {
         return is_future_sold;
     }

    public void setFlag(String flag) {
         this.flag = flag;
     }
     public String getFlag() {
         return flag;
     }

    public void setPrice(String price) {
         this.price = price;
     }
     public String getPrice() {
         return price;
     }

    public void setUpdate_time(Date update_time) {
         this.update_time = update_time;
     }
     public Date getUpdate_time() {
         return update_time;
     }

    public void setSpu_id(int spu_id) {
         this.spu_id = spu_id;
     }
     public int getSpu_id() {
         return spu_id;
     }

    public void setItem_name(String item_name) {
         this.item_name = item_name;
     }
     public String getItem_name() {
         return item_name;
     }

    public void setLow_point(String low_point) {
         this.low_point = low_point;
     }
     public String getLow_point() {
         return low_point;
     }

    public void setBuy_stock(int buy_stock) {
         this.buy_stock = buy_stock;
     }
     public int getBuy_stock() {
         return buy_stock;
     }

    public void setLow_price(String low_price) {
         this.low_price = low_price;
     }
     public String getLow_price() {
         return low_price;
     }

    public void setTitles(List<String> titles) {
         this.titles = titles;
     }
     public List<String> getTitles() {
         return titles;
     }

    public void setSeller_id(long seller_id) {
         this.seller_id = seller_id;
     }
     public long getSeller_id() {
         return seller_id;
     }

    public void setAdd_time(Date add_time) {
         this.add_time = add_time;
     }
     public Date getAdd_time() {
         return add_time;
     }

    public void setPurchase_fee(int purchase_fee) {
         this.purchase_fee = purchase_fee;
     }
     public int getPurchase_fee() {
         return purchase_fee;
     }

    public void setIs_wzx_sup_item(int is_wzx_sup_item) {
         this.is_wzx_sup_item = is_wzx_sup_item;
     }
     public int getIs_wzx_sup_item() {
         return is_wzx_sup_item;
     }

    public void setTax_rate(String tax_rate) {
         this.tax_rate = tax_rate;
     }
     public String getTax_rate() {
         return tax_rate;
     }

}