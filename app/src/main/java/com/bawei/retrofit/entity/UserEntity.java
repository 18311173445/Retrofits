package com.bawei.retrofit.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserEntity {
    @Id(autoincrement = true)
    @Unique
    private long id;
    private String name;
    @Generated(hash = 1611124801)
    public UserEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1433178141)
    public UserEntity() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
