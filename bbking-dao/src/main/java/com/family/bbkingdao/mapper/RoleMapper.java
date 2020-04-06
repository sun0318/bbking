package com.family.bbkingdao.mapper;

import com.family.bbkingdao.entity.Role;
import com.family.bbkingdao.entity.User;

import java.util.Set;

public interface RoleMapper {
    Set<Role> getRoleList(User user);
}
