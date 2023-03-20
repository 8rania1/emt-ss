package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
