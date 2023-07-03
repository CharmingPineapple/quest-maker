package com.example.data.storage;

import com.example.data.storage.models.SkillStorage;

import java.util.List;

public interface AuthorStorageInterface {

    void saveSkill(SkillStorage skillStorage);

    int getSkill(SkillStorage skillStorage);

    List<SkillStorage> getAllSkill();

    void saveAllSkill(List<SkillStorage> listCS);
}
