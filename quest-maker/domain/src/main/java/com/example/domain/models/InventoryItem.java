package com.example.domain.models;

public class InventoryItem {

    public String name;
    public String type;
    public boolean using;

    public InventoryItem(String name, String type, boolean using){
        this.name = name;
        this.type = type;
        this.using = using;
    }

    public InventoryItem(String name, String type){
        this.name = name;
        this.type = type;
        this.using = false;
    }

}
