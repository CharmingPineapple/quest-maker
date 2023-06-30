package com.example.data.repository;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.models.SkillStorage;
import com.example.domain.models.Characteristic;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImplementation implements AuthorRepositoryInterface {

    private AuthorStorageInterface authorStorageInterface;

    public AuthorRepositoryImplementation(AuthorStorageInterface authorStorageInterface){
        this.authorStorageInterface = authorStorageInterface;
    }


    @Override
    public void saveSkill(Characteristic characteristic) {
        authorStorageInterface.saveSkill(skillMapToStorage(characteristic));
    }

    @Override
    public int getSkill(Characteristic characteristic) {
        return authorStorageInterface.getSkill(skillMapToStorage(characteristic));
    }

    private SkillStorage skillMapToStorage(Characteristic characteristic){
        return new SkillStorage(characteristic.name, Integer.parseInt(characteristic.value));
    }

    private Characteristic skillMapToDomain(SkillStorage skillStorage){
        return new Characteristic(skillStorage.name, Integer.toString(skillStorage.value));
    }

    // (#)
    public List<Characteristic> getAll(){

        List<SkillStorage> listCS = authorStorageInterface.getAll();
        List<Characteristic> listC = new ArrayList<>();


        for (SkillStorage one : listCS){
            listC.add(skillMapToDomain(one));
        }

        return listC;
    }


    public void saveAll(List<Characteristic> characteristicList){
        List<SkillStorage> listCS = new ArrayList<>();

        for(Characteristic one: characteristicList){
            listCS.add(skillMapToStorage(one));
        }

        authorStorageInterface.saveAll(listCS);

    }


}
