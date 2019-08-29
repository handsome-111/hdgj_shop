package com.hdgj.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Mr.hj
 * @since 2019-08-28
 */
@TableName("customer")
public class Customer implements UserDetails,Serializable{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 密码token
     */
    private String passwordResetToken;

    /**
     * 邮箱
     */
    private String email;

    private String username;

    /**
     * 1代表订阅，2代表不订阅邮件
     */
    private Integer isSubscribed;

    private String authKey;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Integer createdAt;

    /**
     * 更新时间
     */
    private Integer updatedAt;

    /**
     * 密码
     */
    private String password;

    /**
     * 出生日期
     */
    private LocalDateTime birthDate;

    /**
     * 用户收藏的产品的总数
     */
    private Integer favoriteProductCount;

    /**
     * 默认为default，如果是第三方登录，譬如google账号登录注册，那么这里的值为google
     */
    private String type;

    /**
     * 创建token的时间
     */
    private Integer accessTokenCreatedAt;

    /**
     * 限制次数访问
     */
    private Integer allowance;

    private Integer allowanceUpdatedAt;

    /**
     * 手机号
     */
    private String phone;

    private String roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Integer getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Integer isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getFavoriteProductCount() {
        return favoriteProductCount;
    }

    public void setFavoriteProductCount(Integer favoriteProductCount) {
        this.favoriteProductCount = favoriteProductCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAccessTokenCreatedAt() {
        return accessTokenCreatedAt;
    }

    public void setAccessTokenCreatedAt(Integer accessTokenCreatedAt) {
        this.accessTokenCreatedAt = accessTokenCreatedAt;
    }

    public Integer getAllowance() {
        return allowance;
    }

    public void setAllowance(Integer allowance) {
        this.allowance = allowance;
    }

    public Integer getAllowanceUpdatedAt() {
        return allowanceUpdatedAt;
    }

    public void setAllowanceUpdatedAt(Integer allowanceUpdatedAt) {
        this.allowanceUpdatedAt = allowanceUpdatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
		this.username = username;
	}

	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", passwordResetToken=" + passwordResetToken + ", email=" + email + ", username="
				+ username + ", isSubscribed=" + isSubscribed + ", authKey=" + authKey + ", status=" + status
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", password=" + password + ", birthDate="
				+ birthDate + ", favoriteProductCount=" + favoriteProductCount + ", type=" + type
				+ ", accessTokenCreatedAt=" + accessTokenCreatedAt + ", allowance=" + allowance
				+ ", allowanceUpdatedAt=" + allowanceUpdatedAt + ", phone=" + phone + "]";
	}

	/**
	 * 返回用户拥有的权限
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> authorities = new ArrayList<Role>();
		String[] rls = roles.split(",");
		for(String str : rls){
			Role role = new Role(str);
			authorities.add(role);

		}
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
