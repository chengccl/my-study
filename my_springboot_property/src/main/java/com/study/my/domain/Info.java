package com.study.my.domain;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sk-cailicheng on 2018/6/14.
 */
@Document(collection = "info")
public class Info {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
