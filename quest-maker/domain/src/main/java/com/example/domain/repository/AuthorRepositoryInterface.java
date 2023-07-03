package com.example.domain.repository;

import com.example.domain.models.Skill;

import java.util.List;

public interface AuthorRepositoryInterface {

    void saveSkill(Skill skill);

    int getSkill(Skill skill);

    List<Skill> getAllSkill();
    void saveAllSkill(List<Skill> skillList);

}
