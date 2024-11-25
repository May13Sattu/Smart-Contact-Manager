package com.fortuneteller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortuneteller.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
