package com.hdgj.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 分类
 * @author Administrator
 *
 */
public class Cate {
	@Id
	private Number id;
	
	@Field("cate_id")
	//分类id
	private String cateId;
	
	@Field("cate_name")
	//分类名称
	private String cateName;

	@Field("parent_id")
	//父类目ID
	private Number parentId;
	
	@Field
	//状态
	private Number status;
	
	@Field("created_time")
	//添加时间
	private String createdTime;			
	
	@Field("updated_time")
	//更新时间
	private String updatedTime;	
	
	@Field("url_key")
	//点击分类的链接
	private String urlKey;
	
	public Cate(Number id, String cateId, String cateName, Number parentId, Number status, String createdTime,
			String updatedTime, String urlKey) {
		super();
		this.id = id;
		this.cateId = cateId;
		this.cateName = cateName;
		this.parentId = parentId;
		this.status = status;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.urlKey = urlKey;
	}

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Number getParentId() {
		return parentId;
	}

	public void setParentId(Number parentId) {
		this.parentId = parentId;
	}

	public Number getStatus() {
		return status;
	}

	public void setStatus(Number status) {
		this.status = status;
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

	public String getUrlKey() {
		return urlKey;
	}

	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}

	@Override
	public String toString() {
		return "Cate [id=" + id + ", cateId=" + cateId + ", cateName=" + cateName + ", parentId=" + parentId
				+ ", status=" + status + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + ", urlKey="
				+ urlKey + "]";
	}
	
}



