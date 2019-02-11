package com.spring.microservices.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author sunilsingh
 */
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private Integer userId;
	@NotNull
	@Column(name = "user_name")
	private String userName;
	@NotNull
	@Column(name = "password")
	private String password;
	@Column(name = "user_enabled")
	private char enabled;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role_link", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "roleId"))
	private Set<RoleEntity> role;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Integer userId, String userName, String password, char enabled, Set<RoleEntity> role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char isEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}

	public Set<RoleEntity> getRole() {
		return role;
	}

	public void setRole(Set<RoleEntity> role) {
		this.role = role;
	}

}
