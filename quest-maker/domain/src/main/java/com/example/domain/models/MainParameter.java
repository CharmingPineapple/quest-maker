package com.example.domain.models;

public class MainParameter {

    public String name;
    public String value;

    public MainParameter(String name, String value){
        this.name = name;
        this.value = value;
    }

    public MainParameter(String name){
        this.name = name;
        this.value = "0";
    }

}
