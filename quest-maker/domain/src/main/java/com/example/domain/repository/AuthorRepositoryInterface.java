package com.example.domain.repository;

import com.example.domain.models.PersonItem;

import java.util.List;

public interface AuthorRepositoryInterface {

    void saveSkill(PersonItem skill);

    int getSkill(PersonItem skill);

    List<PersonItem> getAllSkill();
    void saveAllSkill(List<PersonItem> skillList);

    List<PersonItem> getAllMainParameter();

    void saveAllMainParameter(List<PersonItem> mpList);

}
