package com.hdgj.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * 商品，存储于Mongodb
 * @author Administrator
 *
 */
@Document("product")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//商品id
	private String id;
	
	@Field("update_time")
	//更新时间
	private String updateTime;
	
	@Field("edit_time")
	//编辑时间
	private String editTime;
	
	@Field("add_time")
	private String addTime;
	
	@Field("item_desc")
	//商品描述
	private String itemDesc;
	
	@Field("item_name")
	//商品名称
	private String itemName;
	
	@Field("low_price")
	//最低价格
	private String lowPrice;
	
	@Field("high_price")
	//最高价格
	private String highPrice;
	
	@Field("fx_fee_rate")
	//分销分成比例
	private String fxFeeRate;
	
	@Field("seller_id")
	//卖家Id,目前没用的字段
	private Number sellerId;
	
	@Field("merchant_code")
	//商品编号
	private String merchantCode;
	
	@Field
	//商品销量
	private String sold;
	
	@Field
	//商品状态，商品状态（onsale ：销售中 instock：已下架 delete：已删除）
	//商品状态 1: 正常 2: 下架 3:删除

	private Number status;
	
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
	
	@Field
	//商品图片(展示商品的图片/视频)
	private List<String> imgs;
	
	@DBRef
	//skus
	private List<Sku> sku;
	
	@DBRef
	//商品所属分类
	private List<Cate> cates;
	
	@Field("is_top")
	private Integer isTop;
	
	@Field("item_comment")
	//商品描述
	private String itemComment;
	
	@Field("is_need_idno")
	//是否需要清关标志， 1是，0否
	private Number  isNeedIdno;

	@Field("img_head")
	//头图
	private String imgHead;
	
	@Field("buy_stock")
	//可以购买的库存数
	private Number buyStock;
	
	@DBRef/*("item_detail")*/
	private List<ProductDetail> itemDetail;

	/**
	 * 未知属性
	 */
	@Field("is_point_price")
	private Number isPointPrice;
	
	private String flag;
	
	@Field("flag_bin")
	private String flagBin;
	
	@Field("is_tax_rate")
	private Number isTaxRate;
	
	@Field("sup_price")
	private Number supPrice;
	
	@Field("full_imgs")
	private List<String> fullImgs;
	
	@Field("bg_cate_id")
	private String bgCateId;
	
	@Field("is_cvs_item")
	private Number isCvsItem;
	
	@Field("sup_id")
	private Number supId;
	
	@Field("is_future_sold")
	private Number isFutureSold;
	
	@Field("is_only_for_buyer")
	private Number isOnlyForBuyer;
	
	@Field("spu_id")
	private Number spuId;

	@Field("is_wzx_sup_item")
	private Number isWzxSupItem;
	

	
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



	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
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

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public List<Sku> getSku() {
		return sku;
	}

	public void setSku(List<Sku> sku) {
		this.sku= sku;
	}

	public List<Cate> getCates() {
		return cates;
	}

	public void setCates(List<Cate> cates) {
		this.cates = cates;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getEditTime() {
		return editTime;
	}

	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}

	public String getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}

	public String getSold() {
		return sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}

	public String getItemComment() {
		return itemComment;
	}

	public void setItemComment(String itemComment) {
		this.itemComment = itemComment;
	}

	public Number getIsNeedIdno() {
		return isNeedIdno;
	}

	public void setIsNeedIdno(Number isNeedIdno) {
		this.isNeedIdno = isNeedIdno;
	}

	public String getImgHead() {
		return imgHead;
	}

	public void setImgHead(String imgHead) {
		this.imgHead = imgHead;
	}

	public Number getSellerId() {
		return sellerId;
	}

	public void setSellerId(Number sellerId) {
		this.sellerId = sellerId;
	}

	public Number getStatus() {
		return status;
	}

	public void setStatus(Number status) {
		this.status = status;
	}

	public Number getBuyStock() {
		return buyStock;
	}

	public void setBuyStock(Number buyStock) {
		this.buyStock = buyStock;
	}

	public List<ProductDetail> getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(List<ProductDetail> itemDetail) {
		this.itemDetail = itemDetail;
	}

	public Number getIsPointPrice() {
		return isPointPrice;
	}

	public void setIsPointPrice(Number isPointPrice) {
		this.isPointPrice = isPointPrice;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlagBin() {
		return flagBin;
	}

	public void setFlagBin(String flagBin) {
		this.flagBin = flagBin;
	}

	public Number getIsTaxRate() {
		return isTaxRate;
	}

	public void setIsTaxRate(Number isTaxRate) {
		this.isTaxRate = isTaxRate;
	}

	public Number getSupPrice() {
		return supPrice;
	}

	public void setSupPrice(Number supPrice) {
		this.supPrice = supPrice;
	}

	public List<String> getFullImgs() {
		return fullImgs;
	}

	public void setFullImgs(List<String> fullImgs) {
		this.fullImgs = fullImgs;
	}

	public String getBgCateId() {
		return bgCateId;
	}

	public void setBgCateId(String bgCateId) {
		this.bgCateId = bgCateId;
	}

	public Number getIsCvsItem() {
		return isCvsItem;
	}

	public void setIsCvsItem(Number isCvsItem) {
		this.isCvsItem = isCvsItem;
	}

	public Number getSupId() {
		return supId;
	}

	public void setSupId(Number supId) {
		this.supId = supId;
	}

	public Number getIsFutureSold() {
		return isFutureSold;
	}

	public void setIsFutureSold(Number isFutureSold) {
		this.isFutureSold = isFutureSold;
	}

	public Number getIsOnlyForBuyer() {
		return isOnlyForBuyer;
	}

	public void setIsOnlyForBuyer(Number isOnlyForBuyer) {
		this.isOnlyForBuyer = isOnlyForBuyer;
	}

	public Number getSpuId() {
		return spuId;
	}

	public void setSpuId(Number spuId) {
		this.spuId = spuId;
	}

	public Number getIsWzxSupItem() {
		return isWzxSupItem;
	}

	public void setIsWzxSupItem(Number isWzxSupItem) {
		this.isWzxSupItem = isWzxSupItem;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", updateTime=" + updateTime + ", editTime=" + editTime + ", addTime=" + addTime
				+ ", itemDesc=" + itemDesc + ", itemName=" + itemName + ", lowPrice=" + lowPrice + ", highPrice="
				+ highPrice + ", fxFeeRate=" + fxFeeRate + ", sellerId=" + sellerId + ", merchantCode=" + merchantCode
				+ ", sold=" + sold + ", status=" + status + ", stock=" + stock + ", remotefreedelivery="
				+ remotefreedelivery + ", freeDelivery=" + freeDelivery + ", price=" + price + ", titles=" + titles
				+ ", thumbImgs=" + thumbImgs + ", imgs=" + imgs + ", sku=" + sku + ", cates=" + cates + ", isTop="
				+ isTop + ", itemComment=" + itemComment + ", isNeedIdno=" + isNeedIdno + ", imgHead=" + imgHead
				+ ", buyStock=" + buyStock + ", itemDetail=" + itemDetail + ", isPointPrice=" + isPointPrice + ", flag="
				+ flag + ", flagBin=" + flagBin + ", isTaxRate=" + isTaxRate + ", supPrice=" + supPrice + ", fullImgs="
				+ fullImgs + ", bgCateId=" + bgCateId + ", isCvsItem=" + isCvsItem + ", supId=" + supId
				+ ", isFutureSold=" + isFutureSold + ", isOnlyForBuyer=" + isOnlyForBuyer + ", spuId=" + spuId
				+ ", isWzxSupItem=" + isWzxSupItem + "]";
	}

	
	

	



}








