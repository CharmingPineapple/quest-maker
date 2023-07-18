package com.example.domain.models.author;

public class PersonItem {

    public String text;
    public String value;

    public PersonItem(String text, String value){
        this.text = text;
        this.value = value;
    }

    public PersonItem(String text){
        this.text = text;
        this.value = "0";
    }

}
