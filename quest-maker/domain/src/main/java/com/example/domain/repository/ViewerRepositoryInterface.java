package com.example.domain.repository;

import com.example.domain.models.viewer.Equipment;
import com.example.domain.models.viewer.Status;
import com.example.domain.models.viewer.Trinket;
import com.example.domain.models.viewer.Weapon;

import java.util.List;

public interface ViewerRepositoryInterface {

    List<Weapon> getAllWeapon();
    List<Equipment> getAllEquipment();
    List<Trinket> getAllTrinket();

    List<Status> getAllInjury();
    List<Status> getAllCurse();

}
