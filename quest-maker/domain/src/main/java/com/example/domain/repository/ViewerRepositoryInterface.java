package com.example.domain.repository;

import com.example.domain.models.viewer.Equipment;
import com.example.domain.models.viewer.Weapon;

import java.util.List;

public interface ViewerRepositoryInterface {

    List<Weapon> getAllWeapon();
    List<Equipment> getAllEquipment();

}
