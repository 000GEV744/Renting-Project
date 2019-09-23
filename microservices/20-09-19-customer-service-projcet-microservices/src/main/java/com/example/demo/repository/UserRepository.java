package com.example.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;
import java.lang.String;

public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUserId(String userId);

	User findByEmail(String email);
}
