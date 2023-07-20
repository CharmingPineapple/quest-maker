package com.example.domain.repository;

import com.example.domain.models.author.Item;
import com.example.domain.models.author.PersonItem;

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
    List<Item> getAllItem();

    void saveAllItem(List<Item> itemList);
}
