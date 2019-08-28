package com.hdgj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdgj.entity.Customer;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Mr.hj
 * @since 2019-08-28
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
	
	List<Customer> getCustomerAll();
}
