package com.hdgj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hdgj.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.hj
 * @since 2019-09-05
 */
public interface UserService extends IService<User> {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	boolean registerUser(User user);
	/**
	 * 根据openid查找用户
	 * @param openid
	 * @return
	 */
	User findByOpenid(String openid);
}
