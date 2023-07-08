package com.example.data.repository;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.models.PersonItemStorage;
import com.example.domain.models.PersonItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImplementation implements AuthorRepositoryInterface {

    private AuthorStorageInterface authorStorageInterface;

    public AuthorRepositoryImplementation(AuthorStorageInterface authorStorageInterface){
        this.authorStorageInterface = authorStorageInterface;
    }

    @Override
    public void saveSkill(PersonItem skill) {
        authorStorageInterface.saveSkill(PersonItemMapToStorage(skill));
    }

    @Override
    public int getSkill(PersonItem skill) {
        return authorStorageInterface.getSkill(PersonItemMapToStorage(skill));
    }


    public List<PersonItem> getAllSkill(){
        List<PersonItemStorage> listCS = authorStorageInterface.getAllSkill();
        List<PersonItem> listC = new ArrayList<>();

        for (PersonItemStorage one : listCS){
            listC.add(PersonItemMapToDomain(one));
        }

        return listC;
    }


    public void saveAllSkill(List<PersonItem> skillList){
        List<PersonItemStorage> listCS = new ArrayList<>();

        for(PersonItem one: skillList){
            listCS.add(PersonItemMapToStorage(one));
        }

        authorStorageInterface.saveAllSkill(listCS);
    }



    public List<PersonItem> getAllMainParameter(){
        List<PersonItemStorage> listCS = authorStorageInterface.getAllMainParameter();
        List<PersonItem> listC = new ArrayList<>();

        for (PersonItemStorage one : listCS){
            listC.add(PersonItemMapToDomain(one));
        }

        return listC;
    }

    public void saveAllMainParameter(List<PersonItem> mpList){
        List<PersonItemStorage> listCS = new ArrayList<>();

        for(PersonItem one: mpList){
            listCS.add(PersonItemMapToStorage(one));
        }

        authorStorageInterface.saveAllMainParameter(listCS);
    }


    public List<PersonItem> getAllItem(){

        List<PersonItemStorage> listS = authorStorageInterface.getAllItem();
        List<PersonItem> listD = new ArrayList<>();

        for (PersonItemStorage one: listS){
            listD.add(PersonItemMapToDomain(one));
        }

        return listD;
    }

    public void saveAllItem(List<PersonItem> itemList){

    }


    private PersonItemStorage PersonItemMapToStorage(PersonItem mp){
        return new PersonItemStorage(mp.text, Integer.parseInt(mp.value));
    }

    private PersonItem PersonItemMapToDomain(PersonItemStorage mpStorage){
        return new PersonItem(mpStorage.text, Integer.toString(mpStorage.value));
    }

}
