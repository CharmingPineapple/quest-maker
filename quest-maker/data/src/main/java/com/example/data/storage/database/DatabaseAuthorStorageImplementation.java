package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.database.database.personal.adapter.InventoryItemDBAdapter;
import com.example.data.storage.database.database.personal.adapter.MainParameterDBAdapter;
import com.example.data.storage.database.database.personal.adapter.PersonInjuryDBAdapter;
import com.example.data.storage.database.database.personal.adapter.SkillDBAdapter;
import com.example.data.storage.models.author.ItemStorage;
import com.example.data.storage.models.author.PersonItemStorage;


import java.util.List;

public class DatabaseAuthorStorageImplementation implements AuthorStorageInterface {

    private Context context;

    public DatabaseAuthorStorageImplementation(Context context){
        this.context = context;
    }

    @Override
    public void saveSkill(PersonItemStorage skillStorage) {

        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        skillDBAdapter.updateValue(skillStorage.text, skillStorage.value);
        skillDBAdapter.close();

    }

    @Override
    public int getSkill(PersonItemStorage skillStorage) {

        int skillValue;

        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        skillValue = (int) skillDBAdapter.getValueOf(skillStorage.text);
        skillDBAdapter.close();

        return skillValue;
    }

    @Override
    public List<PersonItemStorage> getAllSkill(){
        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        List<PersonItemStorage> list = skillDBAdapter.getAllSkill();
        skillDBAdapter.close();

        return list;
    }

    @Override
    public void saveAllSkill(List<PersonItemStorage> listCS){
        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        skillDBAdapter.saveAllSkill(listCS);
        skillDBAdapter.close();
    }

    @Override
    public List<PersonItemStorage> getAllMainParameter(){
        MainParameterDBAdapter mainParameterDBAdapter = new MainParameterDBAdapter(context);
        mainParameterDBAdapter.open();
        List<PersonItemStorage> list = mainParameterDBAdapter.getAllMainParameter();
        mainParameterDBAdapter.close();

        return list;
    }

    @Override
    public void saveAllMainParameter(List<PersonItemStorage> listCS){
        MainParameterDBAdapter mainParameterDBAdapter = new MainParameterDBAdapter(context);
        mainParameterDBAdapter.open();
        mainParameterDBAdapter.saveAllMainParameter(listCS);
        mainParameterDBAdapter.close();
    }

    public List<ItemStorage> getAllInventoryItem(){
        InventoryItemDBAdapter inventoryItemDBAdapter = new InventoryItemDBAdapter(context);
        inventoryItemDBAdapter.open();
        List<ItemStorage> list = inventoryItemDBAdapter.getAllItem();
        inventoryItemDBAdapter.close();

        return list;
    }

    public void saveAllInventoryItem(List<ItemStorage> list){
        InventoryItemDBAdapter inventoryItemDBAdapter = new InventoryItemDBAdapter(context);
        inventoryItemDBAdapter.open();
        inventoryItemDBAdapter.saveAllItem(list);
        inventoryItemDBAdapter.close();
    }

    public List<ItemStorage> getAllPersonInjury(){
        PersonInjuryDBAdapter personInjuryDBAdapter = new PersonInjuryDBAdapter(context);
        personInjuryDBAdapter.open();
        List<ItemStorage> list = personInjuryDBAdapter.getAllItem();
        personInjuryDBAdapter.close();

        return list;
    }

    public void saveAllPersonInjury(List<ItemStorage> list){
        PersonInjuryDBAdapter personInjuryDBAdapter = new PersonInjuryDBAdapter(context);
        personInjuryDBAdapter.open();
        personInjuryDBAdapter.saveAllItem(list);
        personInjuryDBAdapter.close();
    }





}
