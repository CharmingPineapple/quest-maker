package com.example.domain.repository;

import com.example.domain.models.InventoryItem;
import com.example.domain.models.PersonItem;

import java.util.List;

public interface AuthorRepositoryInterface {

    // FOR TEST

    void saveSkill(PersonItem skill);

    int getSkill(PersonItem skill);

    // SKILL

    List<PersonItem> getAllSkill();
    void saveAllSkill(List<PersonItem> skillList);


    // MAIN PARAM

    List<PersonItem> getAllMainParameter();

    void saveAllMainParameter(List<PersonItem> mpList);

    // ITEMS
    List<InventoryItem> getAllItem();

    void saveAllItem(List<InventoryItem> itemList);
}
