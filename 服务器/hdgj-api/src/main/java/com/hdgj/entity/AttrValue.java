package com.hdgj.entity;

import java.io.Serializable;
import java.math.BigInteger;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Field("attr_id")
	@Indexed(unique=true)
	private BigInteger attrId;		
	//属性值
	@Field("attr_value")
	private String attrValue;
	
	
	public AttrValue(BigInteger attrId, String attrValue) {
		super();
		this.attrId = attrId;
		this.attrValue = attrValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		AttrValue av = new AttrValue();
		if(!attrId.equals(av.getAttrId()) && attrId != null){
			return false;
		}
		if(!attrValue.equals(av.getAttrValue()) && attrValue != null){
			return false;
		}
		return true;
	}
	
	public AttrValue(){}

	public Number getAttrId() {
		return attrId;
	}

	public void setAttrId(BigInteger attrId) {
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
