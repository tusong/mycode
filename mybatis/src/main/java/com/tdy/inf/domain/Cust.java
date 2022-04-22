package com.tdy.inf.domain;

public class Cust {

    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cust{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
