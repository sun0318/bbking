package com.family.bbkingdao.mapper;

import com.family.bbkingdao.entity.Permission;
import com.family.bbkingdao.entity.Role;

import java.util.Set;

public interface PermissionMapper {
    Set<Permission> getPermissionListByRole(Role role);
}
