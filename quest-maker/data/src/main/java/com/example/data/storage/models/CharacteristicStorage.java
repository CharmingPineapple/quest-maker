package com.example.data.storage.models;

public class CharacteristicStorage {

    public String name;
    public int value;

    public CharacteristicStorage(String name, int value){
        this.name = name;
        this.value = value;
    }

    public CharacteristicStorage(String name){
        this.name = name;
        this.value = 0;
    }

}
