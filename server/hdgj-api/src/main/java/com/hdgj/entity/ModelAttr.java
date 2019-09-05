package com.hdgj.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.fastjson.JSONObject;

/**
 * 型号属性，一个型号属性有多个属性值,存储于Mongodb
 * @author Administrator
 *
 */
@Document("model_attr")
public class ModelAttr implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field("attr_title")
	@Id
	//属性值
	private String attrTitle;
	
	@Field("updated_time")
	private String updatedTime;
	
	@DBRef
	private List<AttrValue> attrValues;

	public ModelAttr(String attrTitle, String updatedTime, List<AttrValue> attrValues) {
		super();
		this.attrTitle = attrTitle;
		this.updatedTime = updatedTime;
		this.attrValues = attrValues;
	}
	
	@Override
	public boolean equals(Object obj) {
		String obj1 = JSONObject.toJSONString(this);
		String obj2 = JSONObject.toJSONString(obj);
		System.out.println("是否相等呢："+ obj1.equals(obj2));
		
		return obj1.equals(obj2);
	}
	
	public List<AttrValue> getAttrValues() {
		return attrValues;
	}
	public void setAttrValues(List<AttrValue> attrValues) {
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
