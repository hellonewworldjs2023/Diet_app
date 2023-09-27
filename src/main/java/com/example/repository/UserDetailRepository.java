package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

}
