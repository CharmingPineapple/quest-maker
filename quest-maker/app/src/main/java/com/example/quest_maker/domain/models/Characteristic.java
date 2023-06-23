package com.example.quest_maker.domain.models;

public class Characteristic {

    /*HashMap<String, Byte> CharacteristicsHashMap;

    Characteristics(HashMap<String, Byte> CharacteristicsHashMap){
        this.CharacteristicsHashMap = CharacteristicsHashMap;
    }*/

    public String name;
    public String value;

    public Characteristic(String name, String value){
        this.name = name;
        this.value = value;
    }

    public Characteristic(String name){
        this.name = name;
        this.value = "0";
    }

}
