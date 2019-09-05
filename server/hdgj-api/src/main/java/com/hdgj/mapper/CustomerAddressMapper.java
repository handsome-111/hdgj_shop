package com.hdgj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdgj.entity.Customer;

/**
 * <p>
 * 用户地址表 Mapper 接口
 * </p>
 *
 * @author Mr.hj
 * @since 2019-08-28
 */
@Mapper
public interface CustomerAddressMapper extends BaseMapper<Customer> {

}
