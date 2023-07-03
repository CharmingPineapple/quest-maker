package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.database.adapter.MainParameterDBAdapter;
import com.example.data.storage.database.adapter.SkillDBAdapter;
import com.example.data.storage.models.MainParameterStorage;
import com.example.data.storage.models.SkillStorage;

import java.util.List;

public class DatabaseAuthorStorageImplementation implements AuthorStorageInterface {

    private Context context;

    public DatabaseAuthorStorageImplementation(Context context){
        this.context = context;
    }

    @Override
    public void saveSkill(SkillStorage skillStorage) {

        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        skillDBAdapter.updateValue(skillStorage.name, skillStorage.value);
        skillDBAdapter.close();

    }

    @Override
    public int getSkill(SkillStorage skillStorage) {

        int skillValue;

        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        skillValue = (int) skillDBAdapter.getValueOf(skillStorage.name);
        skillDBAdapter.close();

        return skillValue;
    }

    @Override
    public List<SkillStorage> getAllSkill(){
        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        List<SkillStorage> list = skillDBAdapter.getAllSkill();
        skillDBAdapter.close();

        return list;
    }

    @Override
    public void saveAllSkill(List<SkillStorage> listCS){
        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        skillDBAdapter.saveAllSkill(listCS);
        skillDBAdapter.close();
    }

    @Override
    public List<MainParameterStorage> getAllMainParameter(){
        MainParameterDBAdapter mainParameterDBAdapter = new MainParameterDBAdapter(context);
        mainParameterDBAdapter.open();
        List<MainParameterStorage> list = mainParameterDBAdapter.getAllMainParameter();
        mainParameterDBAdapter.close();

        return list;
    }

    @Override
    public void saveAllMainParameter(List<MainParameterStorage> listCS){
        MainParameterDBAdapter mainParameterDBAdapter = new MainParameterDBAdapter(context);
        mainParameterDBAdapter.open();
        mainParameterDBAdapter.saveAllMainParameter(listCS);
        mainParameterDBAdapter.close();
    }

}
