package com.example.data.repository;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.models.author.ItemStorage;
import com.example.data.storage.models.author.PersonItemStorage;
import com.example.domain.models.author.Item;
import com.example.domain.models.author.PersonItem;
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


    public List<Item> getAllInventoryItem(){
        List<ItemStorage> listS = authorStorageInterface.getAllInventoryItem();
        List<Item> listD = new ArrayList<>();

        for (ItemStorage one: listS){
            listD.add(itemMapToDomain(one));
        }

        return listD;
    }

    public void saveAllInventoryItem(List<Item> listD){
        List<ItemStorage> listS = new ArrayList<>();

        for (Item one: listD){
            listS.add(itemMapToStorage(one));
        }

        authorStorageInterface.saveAllInventoryItem(listS);
    }

    public List<Item> getAllPersonInjury(){
        List<ItemStorage> listS = authorStorageInterface.getAllPersonInjury();
        List<Item> listD = new ArrayList<>();

        for (ItemStorage one: listS){
            listD.add(itemMapToDomain(one));
        }

        return listD;
    }

    public void saveAllPersonInjury(List<Item> listD){
        List<ItemStorage> listS = new ArrayList<>();

        for (Item one: listD){
            listS.add(itemMapToStorage(one));
        }

        authorStorageInterface.saveAllPersonInjury(listS);
    }

    public List<Item> getAllPersonCurse(){
        List<ItemStorage> listS = authorStorageInterface.getAllPersonCurse();
        List<Item> listD = new ArrayList<>();

        for (ItemStorage one: listS){
            listD.add(itemMapToDomain(one));
        }

        return listD;
    }

    public void saveAllPersonCurse(List<Item> listD){
        List<ItemStorage> listS = new ArrayList<>();

        for (Item one: listD){
            listS.add(itemMapToStorage(one));
        }

        authorStorageInterface.saveAllPersonCurse(listS);
    }




    private PersonItemStorage personItemMapToStorage(PersonItem one){
        return new PersonItemStorage(one.text, Integer.parseInt(one.value));
    }

    private PersonItem personItemMapToDomain(PersonItemStorage one){
        return new PersonItem(one.text, Integer.toString(one.value));
    }

    private ItemStorage itemMapToStorage(Item one){
        return new ItemStorage(one.name, one.type);
    }

    private Item itemMapToDomain(ItemStorage one){
        return new Item(one.name, one.type, true);
    }

}
