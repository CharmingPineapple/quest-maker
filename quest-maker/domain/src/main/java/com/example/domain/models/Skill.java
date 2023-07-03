package com.example.domain.models;

public class Skill {

    public String name;
    public String value;

    public Skill(String name, String value){
        this.name = name;
        this.value = value;
    }

    public Skill(String name){
        this.name = name;
        this.value = "0";
    }

}
