package com.spring.microservices.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author sunilsingh
 */
@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleid")
	private Integer roleId;
	@NotNull
	@Column(name = "role_name")
	private String roleName;
	@JsonIgnore
	@ManyToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<UserEntity> userEntity;

	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleEntity(Integer roleId, String roleName, Set<UserEntity> userEntity) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userEntity = userEntity;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserEntity> getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(Set<UserEntity> userEntity) {
		this.userEntity = userEntity;
	}

}
