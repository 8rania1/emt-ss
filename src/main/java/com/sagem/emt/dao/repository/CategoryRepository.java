package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
