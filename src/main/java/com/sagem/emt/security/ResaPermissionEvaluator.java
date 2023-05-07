package com.sagem.emt.security;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.sagem.emt.dao.entity.Permission;
import com.sagem.emt.dao.repository.PermissionRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ResaPermissionEvaluator implements PermissionEvaluator {
	private final PermissionRepository permissionRepository;

	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		if (authentication != null && targetDomainObject instanceof String && permission instanceof String) {
			return hasPrivilege(authentication, String.class.cast(targetDomainObject), String.class.cast(permission));
		}
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		if (authentication != null && StringUtils.isNotBlank(targetType) && permission instanceof String) {
			return hasPrivilege(authentication, targetType, String.class.cast(permission));
		}
		return false;
	}

	private boolean hasPrivilege(Authentication authentication, String targetType, String permission) {
		String requestedPermission = targetType + "." + permission;
		permissionRepository
				.save(permissionRepository.findById(requestedPermission).orElse(new Permission(requestedPermission)));
		return authentication.getAuthorities().stream()
				.anyMatch(item -> StringUtils.equalsAnyIgnoreCase(item.getAuthority(), requestedPermission, "all"));
	}
}
