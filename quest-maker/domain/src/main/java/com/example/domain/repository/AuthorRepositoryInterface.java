package com.example.domain.repository;

import com.example.domain.models.Characteristic;
import com.example.domain.models.CharacteristicList;

import java.util.List;

public interface AuthorRepositoryInterface {

    void saveCharacteristic(Characteristic characteristic);

    int getCharacteristic(Characteristic characteristic);

    List<Characteristic> getAll();
    void saveAll(List<Characteristic> characteristicList);

}
