package com.sagem.emt.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.MovementDirection;
import com.sagem.emt.dao.entity.Reason;
import com.sagem.emt.dao.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
