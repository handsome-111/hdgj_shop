package com.hdgj.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 分类
 * @author Administrator
 *
 */
public class Cate implements Serializable{
	@Id
	@Field("cate_id")
    private long cateId;
	@Field("cate_name")
    private String cateName;
	@Field("sort_num")
    private int sortNum;
	@Field("cate_item_num")
    private int cateItemNum;
    private String listUrl;
    private String shopLogo;
    private String shopName;
    private String description;
	
	public long getCateId() {
		return cateId;
	}
	public void setCateId(long cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getSortNum() {
		return sortNum;
	}
	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
	public int getCateItemNum() {
		return cateItemNum;
	}
	public void setCateItemNum(int cateItemNum) {
		this.cateItemNum = cateItemNum;
	}
	public String getListUrl() {
		return listUrl;
	}
	public void setListUrl(String listUrl) {
		this.listUrl = listUrl;
	}
	public String getShopLogo() {
		return shopLogo;
	}
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Cate [cateId=" + cateId + ", cateName=" + cateName + ", sortNum=" + sortNum + ", cateItemNum="
				+ cateItemNum + ", listUrl=" + listUrl + ", shopLogo=" + shopLogo + ", shopName=" + shopName
				+ ", description=" + description + "]";
	}
    
    
}



