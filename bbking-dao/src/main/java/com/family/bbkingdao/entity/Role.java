package com.family.bbkingdao.entity;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {
    private static final long serialVersionUID = -1568881675913048332L;
    private String id;
    private String roleName;
    private String type;

    public Role() {
    }

    /**
     * 角色对应权限集合
     */
    private Set<Permission> permission;

    public Role(String id, String roleName, Set<Permission> permission) {
        this.id = id;
        this.roleName = roleName;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermission() {
        return permission;
    }

    public void setPermission(Set<Permission> permission) {
        this.permission = permission;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
