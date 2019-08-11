package com.hdgj.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
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
	@Id
	@Field("attr_id")
	private String attrId;
	
	@Field("attr_title")
	//属性值
	private String attrTitle;
	
	@DBRef
	private List<AttrValue> attr_values;

	

	public ModelAttr(String attrId, String attrTitle, List<AttrValue> attr_values) {
		super();
		this.attrId = attrId;
		this.attrTitle = attrTitle;
		this.attr_values = attr_values;
	}

	public List<AttrValue> getAttr_values() {
		return attr_values;
	}

	public void setAttr_values(List<AttrValue> attr_values) {
		this.attr_values = attr_values;
	}

	public String getattrId() {
		return attrId;
	}

	public void setattrId(String attrId) {
		this.attrId = attrId;
	}

	public String getAttrTitle() {
		return attrTitle;
	}

	public void setAttrTitle(String attrTitle) {
		this.attrTitle = attrTitle;
	}

	@Override
	public String toString() {
		return "ModelAttr [id=" + attrId + ", attrTitle=" + attrTitle + ", attr_values=" + attr_values + "]";
	}

	
}
