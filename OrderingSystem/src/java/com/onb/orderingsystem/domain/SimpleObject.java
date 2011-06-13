package com.onb.orderingsystem.domain;

//TODO: dispose me!

import java.io.Serializable;

public class SimpleObject implements Serializable {
    private String name;
    private String dog;
    
    public SimpleObject() {
        name = "Default Name";
        dog = "Default Dogname";
    }
    
    public String getName() {
        return name;
    }
    
    public String getDog() {
        return dog;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDog(String dog) {
        this.dog = dog;
    }
    
    @Override
    public String toString() {
        return "Name: "+name+" Dog: "+dog;
    }
}
