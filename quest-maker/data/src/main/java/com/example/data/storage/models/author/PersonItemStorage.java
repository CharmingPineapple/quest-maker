package com.example.data.storage.models.author;

public class PersonItemStorage {

    public String text;
    public int value;

    public PersonItemStorage(String text, int value){
        this.text = text;
        this.value = value;
    }

    public PersonItemStorage(String text){
        this.text = text;
        this.value = 0;
    }


}
