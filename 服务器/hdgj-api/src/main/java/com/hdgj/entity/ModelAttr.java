package com.hdgj.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	
	@Field("updated_time")
	private String updatedTime;
	
	@DBRef
	@Field("attr_values")
	private List<AttrValue> attrValues;

	public static void a(){
		java.lang.reflect.Field fields[] = ModelAttr.class.getFields();
		for(java.lang.reflect.Field field : fields){
			System.out.println(1);
			System.out.println(field.getAnnotations());
		}
	}

	public ModelAttr(String attrId, String attrTitle, List<AttrValue> attrValues) {
		super();
		this.attrId = attrId;
		this.attrTitle = attrTitle;
		this.attrValues = attrValues;
	}

	public String getAttrId() {
		return attrId;
	}

	public void setAttrId(String attrId) {
		this.attrId = attrId;
	}

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
		return "ModelAttr [attrId=" + attrId + ", attrTitle=" + attrTitle + ", updatedTime=" + updatedTime
				+ ", attrValues=" + attrValues + "]";
	}

	

	
}
