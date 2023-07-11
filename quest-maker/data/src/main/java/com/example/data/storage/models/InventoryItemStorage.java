package com.example.data.storage.models;

public class InventoryItemStorage {

    public String name;
    public String type;
    public int value;

    public InventoryItemStorage(String name, String type, int value){
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public InventoryItemStorage(String name, String type){
        this.name = name;
        this.type = type;
        this.value = 0;
    }

}
