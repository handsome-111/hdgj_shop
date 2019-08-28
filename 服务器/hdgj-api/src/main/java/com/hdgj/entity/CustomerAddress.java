package com.hdgj.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author Mr.hj
 * @since 2019-08-28
 */
@TableName("customer_address")
public class CustomerAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;

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
    private Integer customerId;

    /**
     * 创建时间戳
     */
    private Integer createdAt;

    /**
     * 更新时间戳
     */
    private Integer updatedAt;

    /**
     * 1代表是默认地址，2代表不是
     */
    private Integer isDefault;

    /**
     * 身份证号
     */
    @TableField("idCardNo")
    private String idCardNo;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
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
        return "CustomerAddress{" +
        "addressId=" + addressId +
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
        ", customerId=" + customerId +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        ", isDefault=" + isDefault +
        ", idCardNo=" + idCardNo +
        "}";
    }
}
