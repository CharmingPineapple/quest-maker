package com.example.domain.models;

public class InventoryItem {

    public String name;
    public String type;
    public boolean selected;

    public InventoryItem(String name, String type, boolean selected){
        this.name = name;
        this.type = type;
        this.selected = selected;
    }

    public InventoryItem(String name, String type){
        this.name = name;
        this.type = type;
        this.selected = false;
    }

}
