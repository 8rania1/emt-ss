package com.sagem.emt.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagem.emt.dao.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
