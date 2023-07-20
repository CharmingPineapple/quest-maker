package com.example.domain.models.author;

public class Item {

    public String name;
    public String type;
    public boolean selected;

    public Item(String name, String type, boolean selected){
        this.name = name;
        this.type = type;
        this.selected = selected;
    }

    public Item(String name, String type){
        this.name = name;
        this.type = type;
        this.selected = false;
    }

}
