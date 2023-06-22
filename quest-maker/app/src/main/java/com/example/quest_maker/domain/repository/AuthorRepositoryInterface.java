package com.example.quest_maker.domain.repository;

import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.models.SaveCharacteristicParam;

import java.util.List;

public interface AuthorRepositoryInterface {

    public boolean saveCharacteristic(SaveCharacteristicParam saveCharacteristicParam);

    public short getCharacteristic(Characteristic characteristic);

    // (#)
    public List<SaveCharacteristicParam> getAll();

}
