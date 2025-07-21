package com.learning.leraning_spring;

public class Challenge {
    private Long id;
    private String month;
    private String name;

    public Challenge(Long id, String name, String month) {
        this.id = id;
        this.name = name;
        this.month = month;
    }

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setName(String name) {
        this.name = name;
    }
}
