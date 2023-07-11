package com.example.data.storage;

import com.example.data.storage.models.InventoryItemStorage;
import com.example.data.storage.models.PersonItemStorage;
import com.example.data.storage.models.WeaponStorage;


import java.util.List;

public interface AuthorStorageInterface {

    void saveSkill(PersonItemStorage skillStorage);

    int getSkill(PersonItemStorage skillStorage);

    List<PersonItemStorage> getAllSkill();

    void saveAllSkill(List<PersonItemStorage> listCS);

    List<PersonItemStorage> getAllMainParameter();

    void saveAllMainParameter(List<PersonItemStorage> listCS);

    List<InventoryItemStorage> getAllInvItem();

    void saveAllInvItem(List<InventoryItemStorage> list);

    List<WeaponStorage> getAllWeapon();
}
