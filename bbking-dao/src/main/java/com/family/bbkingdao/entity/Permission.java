package com.family.bbkingdao.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = 6602563391112439862L;
    private String id;
    private String url;
    private String name;

    public Permission(String id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public Permission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
