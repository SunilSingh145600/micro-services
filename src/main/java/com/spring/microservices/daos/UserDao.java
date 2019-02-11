package com.spring.microservices.daos;

import java.util.List;

import com.spring.microservices.entities.UserEntity;

/**
 * @author SunilSingh
 */
public interface UserDao {

	public void saveUser(UserEntity userEntity);

	public void deleteUser(UserEntity userEntity);

	public UserEntity findUserById(Integer userId);

	public List<UserEntity> findAllUser();

	char isUserEnabled();
	
	char isUserExist(String userName, String password);
}
