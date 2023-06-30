package com.example.data.storage.models;

public class SkillStorage {

    public String name;
    public int value;

    public SkillStorage(String name, int value){
        this.name = name;
        this.value = value;
    }

    public SkillStorage(String name){
        this.name = name;
        this.value = 0;
    }

}
