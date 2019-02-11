package com.spring.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservices.daos.UserDao;
import com.spring.microservices.entities.UserEntity;

/**
 * @author SunilSingh
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void saveUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userDao.saveUser(userEntity);
	}

	@Override
	public void deleteUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userEntity);
	}

	@Override
	public UserEntity findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userId);
	}

	@Override
	public List<UserEntity> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	@Override
	public char isUserEnabled() {
		// TODO Auto-generated method stub
		return userDao.isUserEnabled();
	}

	@Override
	public char isUserExist(String userName, String password) {
		// TODO Auto-generated method stub
		return isUserExist(userName, password);
	}

}
