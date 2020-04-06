package com.family.bbkingservice.impl;

import com.family.bbkingdao.entity.Permission;
import com.family.bbkingdao.entity.Role;
import com.family.bbkingdao.mapper.PermissionMapper;
import com.family.bbkingservice.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service(value = "permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> getPermissionsList(Permission permission) {
        return null;
    }

    @Override
    public Set<Permission> getPermissionListByRole(Role role) {
        return permissionMapper.getPermissionListByRole(role);
    }
}
