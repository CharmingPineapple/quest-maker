package com.example.domain.repository;

import com.example.domain.models.InventoryItem;
import com.example.domain.models.PersonItem;
import com.example.domain.models.Weapon;

import java.util.List;

public interface ViewerRepositoryInterface {

    List<Weapon> getAllWeapon();

}
