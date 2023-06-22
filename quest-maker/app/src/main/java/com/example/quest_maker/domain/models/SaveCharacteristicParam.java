package com.example.quest_maker.domain.models;

import java.util.HashMap;

public class SaveCharacteristicParam {

    //HashMap<String, Byte> CharacteristicsHashMap;

    public String destination;
    public int value;

    public SaveCharacteristicParam(String destination, int value){
        this.destination = destination;
        this.value = value;
    }

}
