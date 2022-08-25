package com.heying.spring.javaconfig;

public class CCC {
    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "CCC{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CCC(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
