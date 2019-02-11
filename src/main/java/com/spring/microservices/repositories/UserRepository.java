package com.spring.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.microservices.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	@Query(value = "SELECT user_enabled FROM User  WHERE user_enabled = 'T'", nativeQuery = true)
	char isUserEnabled();

	@Query(value = "SELECT user_enabled FROM User WHERE user_name = ?1 and password= ?2", nativeQuery = true)
	char isUserExist(String userName, String password);
}
