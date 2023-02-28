package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
