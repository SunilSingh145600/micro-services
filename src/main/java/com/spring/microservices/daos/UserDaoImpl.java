package com.spring.microservices.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.microservices.entities.UserEntity;
import com.spring.microservices.repositories.UserRepository;

/**
 * @author SunilSingh
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userRepository.save(userEntity);
	}

	@Override
	public void deleteUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userRepository.delete(userEntity);
	}

	@Override
	public UserEntity findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).get();
	}

	@Override
	public List<UserEntity> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public char isUserEnabled() {
		// TODO Auto-generated method stub
		return userRepository.isUserEnabled();
	}

	@Override
	public char isUserExist(String userName, String password) {
		// TODO Auto-generated method stub
		return userRepository.isUserExist(userName,password);
	}

}
