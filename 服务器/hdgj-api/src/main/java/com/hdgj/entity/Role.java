package com.hdgj.entity;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority{

	private String roleName;
	
	
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getAuthority() {
		return roleName;
	}

}
