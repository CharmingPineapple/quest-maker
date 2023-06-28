package com.example.data.storage;

import com.example.data.storage.models.CharacteristicStorage;
import com.example.domain.models.CharacteristicList;

import java.util.List;

public interface AuthorStorageInterface {

    void saveCharacteristic(CharacteristicStorage characteristicStorage);

    int getCharacteristic(CharacteristicStorage characteristicStorage);

    List<CharacteristicStorage> getAll();

    void saveAll(List<CharacteristicStorage> listCS);
}
