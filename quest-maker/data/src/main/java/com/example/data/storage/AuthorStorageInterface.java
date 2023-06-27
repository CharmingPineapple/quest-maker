package com.example.data.storage;

import com.example.data.storage.models.CharacteristicStorage;
import com.example.domain.models.CharacteristicList;

import java.util.List;

public interface AuthorStorageInterface {

    public boolean saveCharacteristic(CharacteristicStorage characteristicStorage);

    public int getCharacteristic(CharacteristicStorage characteristicStorage);

    // (#)
    public List<CharacteristicStorage> getAll();

}
