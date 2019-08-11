package com.hdgj.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 模型的属性值
 * @author Administrator
 *
 */
@Document(collection="attr_value")
public class AttrValue implements Serializable{
	//属性ID
	@Id
	private int attrId;		
	//属性值
	@Field("attr_value")
	private String attrValue;
	
	
	public AttrValue(int attrId, String attrValue) {
		super();
		this.attrId = attrId;
		this.attrValue = attrValue;
	}
	
	public AttrValue(){}
	
	public int getAttrId() {
		return attrId;
	}
	public void setAttrId(int attrId) {
		this.attrId = attrId;
	}
	public String getAttrValue() {
		return attrValue;
	}
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	@Override
	public String toString() {
		return "AttrValue [attrId=" + attrId + ", attrValue=" + attrValue + "]";
	}		
	
		
}
