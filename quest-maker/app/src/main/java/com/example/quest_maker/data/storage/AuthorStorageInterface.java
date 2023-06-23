package com.example.quest_maker.data.storage;

import com.example.quest_maker.data.storage.models.CharacteristicStorage;

import java.util.List;

public interface AuthorStorageInterface {

    public boolean saveCharacteristic(CharacteristicStorage characteristicStorage);

    public int getCharacteristic(CharacteristicStorage characteristicStorage);

    // (#)
    public List<CharacteristicStorage> getAll();

}
