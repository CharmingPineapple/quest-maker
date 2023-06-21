package com.example.quest_maker.domain.models;

import java.util.HashMap;

public class SaveCharacteristicParam {

    HashMap<String, Byte> CharacteristicsHashMap;

    public String destination;
    public int value;

    SaveCharacteristicParam(String destination, int value){
        //this.CharacteristicsHashMap = CharacteristicsHashMap;

        this.destination = destination;
        this.value = value;

    }

}
