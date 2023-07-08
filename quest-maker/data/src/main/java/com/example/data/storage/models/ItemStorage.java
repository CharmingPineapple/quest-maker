package com.example.data.storage.models;

public class ItemStorage {

    public String type;
    public int id;

    public ItemStorage(String type, int id){
        this.type = type;
        this.id = id;
    }

    public ItemStorage(String type){
        this.type = type;
        this.id = 0;
    }


}
