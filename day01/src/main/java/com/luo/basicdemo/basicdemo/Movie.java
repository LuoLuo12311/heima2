package com.luo.basicdemo.basicdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Movie {
    private String name;
    private String actor;

    public Movie(String name, String actor) {
        this.name = name;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "电影名：" + name + ", 主演：" + actor;
    }
} 