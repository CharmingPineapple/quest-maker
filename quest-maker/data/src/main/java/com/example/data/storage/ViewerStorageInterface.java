package com.example.data.storage;

import com.example.data.storage.models.viewer.EquipmentStorage;
import com.example.data.storage.models.viewer.WeaponStorage;

import java.util.List;

public interface ViewerStorageInterface {

    List<WeaponStorage> getAllWeapon();
    List<EquipmentStorage> getAllEquipment();

}
