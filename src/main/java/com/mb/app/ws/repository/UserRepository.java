package com.mb.app.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mb.app.ws.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public Optional<UserEntity> findByEmail(String email);
	
	public Optional<UserEntity> findByUserId(String userId);
	
	@Transactional
	public void deleteByUserId(String userId);
	
}
                     