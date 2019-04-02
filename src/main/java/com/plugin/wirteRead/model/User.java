package com.plugin.wirteRead.model;

import java.io.Serializable;

/**
 * Created by zl on 2015/8/27.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6171929942205372936L;
    private java.lang.String id;//
    private java.lang.String name;// 配置名称
    private java.lang.String value;// 配置值
    private java.lang.String createTime;// 配置时间
    private java.lang.String configDescribe;// 描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getConfigDescribe() {
        return configDescribe;
    }

    public void setConfigDescribe(String configDescribe) {
        this.configDescribe = configDescribe;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", createTime='" + createTime + '\'' +
                ", configDescribe='" + configDescribe + '\'' +
                '}';
    }
}
