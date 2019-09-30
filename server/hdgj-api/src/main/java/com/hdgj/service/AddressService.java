package com.hdgj.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdgj.entity.Address;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.hj
 * @since 2019-09-19
 */
public interface AddressService extends IService<Address> {
	List<Address> selectByUserid(String userid);
	boolean updateAddress(Address address, int oldId);
	/**
	 * 寻找默认地址
	 * @param userid
	 * @return
	 */
	Address findDefaultAddress(String userid);		
}
