package com.sagem.emt.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    List<Status> findByDirection(MovementDirection direction);
}
