package com.hdgj.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	private String id;
	@Field("attr_id")
	@Indexed(unique=true)
	private Number attrId;		
	//属性值
	@Field("attr_value")
	private String attrValue;
	
	
	public AttrValue(int attrId, String attrValue) {
		super();
		this.attrId = attrId;
		this.attrValue = attrValue;
	}
	
	public AttrValue(){}

	public Number getAttrId() {
		return attrId;
	}

	public void setAttrId(Number attrId) {
		this.attrId = attrId;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AttrValue [id=" + id + ", attrId=" + attrId + ", attrValue=" + attrValue + "]";
	}

	
	
	
		
	
		
}
