package com.example.data.repository;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.models.MainParameterStorage;
import com.example.data.storage.models.SkillStorage;
import com.example.domain.models.MainParameter;
import com.example.domain.models.Skill;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImplementation implements AuthorRepositoryInterface {

    private AuthorStorageInterface authorStorageInterface;

    public AuthorRepositoryImplementation(AuthorStorageInterface authorStorageInterface){
        this.authorStorageInterface = authorStorageInterface;
    }

    @Override
    public void saveSkill(Skill skill) {
        authorStorageInterface.saveSkill(skillMapToStorage(skill));
    }

    @Override
    public int getSkill(Skill skill) {
        return authorStorageInterface.getSkill(skillMapToStorage(skill));
    }



    // (#)
    public List<Skill> getAllSkill(){
        List<SkillStorage> listCS = authorStorageInterface.getAllSkill();
        List<Skill> listC = new ArrayList<>();

        for (SkillStorage one : listCS){
            listC.add(skillMapToDomain(one));
        }

        return listC;
    }


    public void saveAllSkill(List<Skill> skillList){
        List<SkillStorage> listCS = new ArrayList<>();

        for(Skill one: skillList){
            listCS.add(skillMapToStorage(one));
        }

        authorStorageInterface.saveAllSkill(listCS);
    }



    public List<MainParameter> getAllMainParameter(){
        List<MainParameterStorage> listCS = authorStorageInterface.getAllMainParameter();
        List<MainParameter> listC = new ArrayList<>();

        for (MainParameterStorage one : listCS){
            listC.add(MainParameterMapToDomain(one));
        }

        return listC;
    }

    public void saveAllMainParameter(List<MainParameter> mpList){
        List<MainParameterStorage> listCS = new ArrayList<>();

        for(MainParameter one: mpList){
            listCS.add(MainParameterMapToStorage(one));
        }

        authorStorageInterface.saveAllMainParameter(listCS);
    }

    private SkillStorage skillMapToStorage(Skill skill){
        return new SkillStorage(skill.name, Integer.parseInt(skill.value));
    }

    private Skill skillMapToDomain(SkillStorage skillStorage){
        return new Skill(skillStorage.name, Integer.toString(skillStorage.value));
    }

    private MainParameterStorage MainParameterMapToStorage(MainParameter mp){
        return new MainParameterStorage(mp.name, Integer.parseInt(mp.value));
    }

    private MainParameter MainParameterMapToDomain(MainParameterStorage mpStorage){
        return new MainParameter(mpStorage.name, Integer.toString(mpStorage.value));
    }

}
