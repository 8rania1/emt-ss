package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}
