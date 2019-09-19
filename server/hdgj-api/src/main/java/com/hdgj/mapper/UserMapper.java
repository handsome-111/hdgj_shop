package com.hdgj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdgj.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.hj
 * @since 2019-09-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	User selectUserByopenid(String openid);
	User selectByOpenid(String opendid);
}
