package com.example.data.storage;

import com.example.data.storage.models.SkillStorage;

import java.util.List;

public interface AuthorStorageInterface {

    void saveSkill(SkillStorage skillStorage);

    int getSkill(SkillStorage skillStorage);

    List<SkillStorage> getAll();

    void saveAll(List<SkillStorage> listCS);
}
