package com.sagem.emt.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.Reason;

public interface ReasonRepository extends JpaRepository<Reason, Long> {
    List<Reason> findByDirection(MovementDirection direction);
}
