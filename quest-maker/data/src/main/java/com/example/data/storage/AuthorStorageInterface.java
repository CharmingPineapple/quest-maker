package com.example.data.storage;

import com.example.data.storage.models.author.ItemStorage;
import com.example.data.storage.models.author.PersonItemStorage;

import java.util.List;

public interface AuthorStorageInterface {

    void saveSkill(PersonItemStorage skillStorage);

    int getSkill(PersonItemStorage skillStorage);

    List<PersonItemStorage> getAllSkill();

    void saveAllSkill(List<PersonItemStorage> listCS);

    List<PersonItemStorage> getAllMainParameter();

    void saveAllMainParameter(List<PersonItemStorage> listCS);

    List<ItemStorage> getAllInventoryItem();

    void saveAllInventoryItem(List<ItemStorage> list);
    List<ItemStorage> getAllPersonInjury();

    void saveAllPersonInjury(List<ItemStorage> list);


}
