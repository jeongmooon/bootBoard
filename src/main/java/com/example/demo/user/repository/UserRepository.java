package com.sutdy.boot.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sutdy.boot.user.entity.UserT;

public interface UserRepository extends JpaRepository<UserT, Long> {
	Optional<UserT> findByUsername(String username);
}
