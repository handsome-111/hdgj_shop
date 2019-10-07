package com.hdgj.entity;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 购物车
 * @author Administrator
 *
 */
@Document(collection = "cart")
public class Cart {
	@Id
	private String id;

	private int userid;

	@DBRef
	private Product product;

	private int number;

	private int status;

	@Field("create_time")
	private DateTime createTime;

	@Field("update_time")
	private DateTime updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	public DateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}

	public DateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(DateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userid=" + userid + ", product=" + product + ", number=" + number + ", status="
				+ status + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	

	

	
}
