package com.hdgj.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hdgj.entity.Address;
import com.hdgj.mapper.AddressMapper;
import com.hdgj.service.AddressService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.hj
 * @since 2019-09-19
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
