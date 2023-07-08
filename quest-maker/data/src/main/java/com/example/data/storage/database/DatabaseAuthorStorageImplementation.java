package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.database.adapter.MainParameterDBAdapter;
import com.example.data.storage.database.adapter.SkillDBAdapter;
import com.example.data.storage.models.PersonItemStorage;

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

}
