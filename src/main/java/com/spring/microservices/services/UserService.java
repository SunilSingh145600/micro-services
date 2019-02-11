package com.spring.microservices.services;

import java.util.List;

import com.spring.microservices.entities.UserEntity;

public interface UserService {

	public void saveUser(UserEntity userEntity);

	public void deleteUser(UserEntity userEntity);

	public UserEntity findUserById(Integer userId);

	public List<UserEntity> findAllUser();

	char isUserEnabled();

	char isUserExist(String userName, String password);

}
