package com.mb.app.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.app.ws.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public Optional<UserEntity> findByEmail(String email);
	
	public Optional<UserEntity> findByUserId(String userId);
}
