package com.example.data.repository;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.models.InventoryItemStorage;
import com.example.data.storage.models.PersonItemStorage;
import com.example.domain.models.InventoryItem;
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
        authorStorageInterface.saveSkill(personItemMapToStorage(skill));
    }

    @Override
    public int getSkill(PersonItem skill) {
        return authorStorageInterface.getSkill(personItemMapToStorage(skill));
    }


    public List<PersonItem> getAllSkill(){
        List<PersonItemStorage> listCS = authorStorageInterface.getAllSkill();
        List<PersonItem> listC = new ArrayList<>();

        for (PersonItemStorage one : listCS){
            listC.add(personItemMapToDomain(one));
        }

        return listC;
    }


    public void saveAllSkill(List<PersonItem> skillList){
        List<PersonItemStorage> listCS = new ArrayList<>();

        for(PersonItem one: skillList){
            listCS.add(personItemMapToStorage(one));
        }

        authorStorageInterface.saveAllSkill(listCS);
    }



    public List<PersonItem> getAllMainParameter(){
        List<PersonItemStorage> listCS = authorStorageInterface.getAllMainParameter();
        List<PersonItem> listC = new ArrayList<>();

        for (PersonItemStorage one : listCS){
            listC.add(personItemMapToDomain(one));
        }

        return listC;
    }

    public void saveAllMainParameter(List<PersonItem> mpList){
        List<PersonItemStorage> listCS = new ArrayList<>();

        for(PersonItem one: mpList){
            listCS.add(personItemMapToStorage(one));
        }

        authorStorageInterface.saveAllMainParameter(listCS);
    }


    public List<InventoryItem> getAllItem(){
        List<InventoryItemStorage> listS = authorStorageInterface.getAllItem();
        List<InventoryItem> listD = new ArrayList<>();

        for (InventoryItemStorage one: listS){
            listD.add(inventoryItemMapToDomain(one));
        }

        return listD;
    }

    public void saveAllItem(List<InventoryItem> listD){
        List<InventoryItemStorage> listS = new ArrayList<>();

        for (InventoryItem one: listD){
            listS.add(inventoryItemMapToStorage(one));
        }

        authorStorageInterface.saveAllItem(listS);
    }


    private PersonItemStorage personItemMapToStorage(PersonItem one){
        return new PersonItemStorage(one.text, Integer.parseInt(one.value));
    }

    private PersonItem personItemMapToDomain(PersonItemStorage one){
        return new PersonItem(one.text, Integer.toString(one.value));
    }

    private InventoryItemStorage inventoryItemMapToStorage(InventoryItem one){
        return new InventoryItemStorage(one.name, one.type, Integer.parseInt(one.value));
    }

    private InventoryItem inventoryItemMapToDomain(InventoryItemStorage one){
        return new InventoryItem(one.name, one.type, Integer.toString(one.value));
    }

}
