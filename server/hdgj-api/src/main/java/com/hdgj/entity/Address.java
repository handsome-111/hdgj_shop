package com.hdgj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType; 
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Mr.hj
 * @since 2019-09-19
 */
@TableName("address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 姓名
     */
    private String name;

    /**
     * 公司
     */
    private String company;

    /**
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 街道地址1
     */
    private String street1;

    /**
     * 街道地址2
     */
    private String street2;

    /**
     * 城市
     */
    private String city;

    /**
     * 省/州
     */
    private String province;

    /**
     * 邮编
     */
    private String post;

    /**
     * 收货人所在区
     */
    private String region;

    /**
     * 国家
     */
    private String country;

    /**
     * 用户的id
     */
    @TableField(value = "userid", el = "user.id")
    private User user;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    private LocalDateTime updateTime;

    /**
     * 1代表是默认地址，2代表不是
     */
    private Integer isDefault;

    /**
     * 身份证号
     */
    @TableField("idCardNo")
    private String idCardNo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

   

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    @Override
    public String toString() {
        return "Address{" +
        "id=" + id +
        ", email=" + email +
        ", name=" + name +
        ", company=" + company +
        ", phone=" + phone +
        ", fax=" + fax +
        ", street1=" + street1 +
        ", street2=" + street2 +
        ", city=" + city +
        ", province=" + province +
        ", post=" + post +
        ", region=" + region +
        ", country=" + country +
        ", userid=" + user.getId() +
        ", createdTime=" + createdTime +
        ", updateTime=" + updateTime +
        ", isDefault=" + isDefault +
        ", idCardNo=" + idCardNo +
        "}";
    }
}
