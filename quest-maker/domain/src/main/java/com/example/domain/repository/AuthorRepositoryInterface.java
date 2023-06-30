package com.example.domain.repository;

import com.example.domain.models.Characteristic;

import java.util.List;

public interface AuthorRepositoryInterface {

    void saveSkill(Characteristic characteristic);

    int getSkill(Characteristic characteristic);

    List<Characteristic> getAll();
    void saveAll(List<Characteristic> characteristicList);

}
