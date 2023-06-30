package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.database.personal.adapter.SkillDBAdapter;
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
    public List<SkillStorage> getAll(){
        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        List<SkillStorage> list = skillDBAdapter.getAllCharacteristics();
        skillDBAdapter.close();

        return list;
    }

    @Override
    public void saveAll(List<SkillStorage> listCS){
        SkillDBAdapter skillDBAdapter = new SkillDBAdapter(context);
        skillDBAdapter.open();
        skillDBAdapter.saveAllSkill(listCS);
        skillDBAdapter.close();
    }

}
