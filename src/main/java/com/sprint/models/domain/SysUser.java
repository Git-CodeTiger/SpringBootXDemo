package com.sprint.models.domain;

import com.sprint.models.dao.SysRoleDao;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.List;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.ArrayList;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
public class SysUser implements Serializable, UserDetails{
	private static final long serialVersionUID = 1L; 
	private Long id;
	private String username;
	private String password;
	private String  role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority(this.role));
		return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;	
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setRole(String role) {
		this.role = role;
 	}

	public String getRole() {
		return role;
	}
}

