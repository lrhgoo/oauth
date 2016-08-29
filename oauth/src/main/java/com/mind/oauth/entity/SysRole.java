package com.mind.oauth.entity;

import javax.persistence.*;

/**
 * Created by lrh on 2016/8/12.
 */
@Entity
@Table(name = "sys_role")
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name",length = 20,nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
