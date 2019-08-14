package com.hdgj.entity;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
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
public class ModelAttr {

	
	@Field("attr_title")
	@Indexed(unique=true)
	//属性值
	private String attrTitle;
	
	@Field("updated_time")
	private String updatedTime;
	
	@DBRef
	private List<AttrValue> attrValues;

	@Override
	public boolean equals(Object modelAttr) {
		String ma= JSONObject.toJSONString(modelAttr);
		String th = JSONObject.toJSONString(this);
		if(ma.equals(th)){
			return true;
		}
		return false;
	}


	public ModelAttr(){}



	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<AttrValue> getattrValues() {
		return attrValues;
	}

	public void setattrValues(List<AttrValue> attrValues) {
		this.attrValues = attrValues;
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
