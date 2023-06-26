package com.example.domain.repository;

import com.example.domain.models.Characteristic;

import java.util.List;

public interface AuthorRepositoryInterface {

    public boolean saveCharacteristic(Characteristic characteristic);

    public int getCharacteristic(Characteristic characteristic);

    // (#)
    public List<Characteristic> getAll();

}
