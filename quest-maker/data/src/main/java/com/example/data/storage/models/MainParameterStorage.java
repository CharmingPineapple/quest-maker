package com.example.data.storage.models;

public class MainParameterStorage {

    public String name;
    public int value;

    public MainParameterStorage(String name, int value){
        this.name = name;
        this.value = value;
    }

    public MainParameterStorage(String name){
        this.name = name;
        this.value = 0;
    }


}
