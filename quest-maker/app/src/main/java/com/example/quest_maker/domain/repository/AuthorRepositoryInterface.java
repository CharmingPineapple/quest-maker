package com.example.quest_maker.domain.repository;

import com.example.quest_maker.domain.models.Characteristic;

import java.util.List;

public interface AuthorRepositoryInterface {

    public boolean saveCharacteristic(Characteristic characteristic);

    public int getCharacteristic(Characteristic characteristic);

    // (#)
    public List<Characteristic> getAll();

}
