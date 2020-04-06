package com.family.bbkingservice;

import com.family.bbkingdao.entity.Permission;
import com.family.bbkingdao.entity.Role;
import com.family.bbkingdao.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PermissionService {
    List<Permission> getPermissionsList(Permission permissions);
    Set<Permission> getPermissionListByRole(Role role);
}
