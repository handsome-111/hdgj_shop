package com.hdgj.entity;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("role")
public class Role implements Serializable,GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String rolename;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
   

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}

	@Override
	public String getAuthority() {
		return rolename;
	}
}
