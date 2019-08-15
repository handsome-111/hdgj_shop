package com.hdgj.entity;

import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 型号属性，一个型号属性有多个属性值,存储于Mongodb
 * @author Administrator
 *
 */
@Document("model_attr")
public class ModelAttr {

	
	@Field("attr_title")
	//属性值
	private String attrTitle;
	
	@Field("updated_time")
	private String updatedTime;
	
	@DBRef
	private List<AttrValue> attrValues;

	public List<AttrValue> getAttrValues() {
		return attrValues;
	}
	public void setAttrValues(List<AttrValue> attrValues) {
		this.attrValues = attrValues;
	}

	@PersistenceConstructor
	public ModelAttr(String attrTitle, String updatedTime, List<AttrValue> attrValues) {
		super();
		this.attrTitle = attrTitle;
		this.updatedTime = updatedTime;
		this.attrValues = attrValues;
	}
	public ModelAttr(){}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getAttrTitle() {
		return attrTitle;
	}

	public void setAttrTitle(String attrTitle) {
		this.attrTitle = attrTitle;
	}

	@Override
	public String toString() {
		return "ModelAttr [ attrTitle=" + attrTitle + ", updatedTime=" + updatedTime
				+ ", attrValues=" + attrValues + "]";
	}

	

	
}
