package com.example.domain.models;

public class Characteristic {

    public String name;
    public String value;

    public Characteristic(String name, String value){
        this.name = name;
        this.value = value;
    }

    public Characteristic(String name){
        this.name = name;
        this.value = "0";
    }

}
