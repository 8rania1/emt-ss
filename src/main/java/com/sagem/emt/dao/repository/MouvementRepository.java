package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Mouvement;

public interface MouvementRepository extends JpaRepository<Mouvement, Long> {

}
