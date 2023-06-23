package com.example.quest_maker.data.storage.database;

import android.content.Context;

import com.example.quest_maker.data.storage.AuthorStorageInterface;
import com.example.quest_maker.data.storage.database.personal.adapter.CharacteristicsDBAdapter;
import com.example.quest_maker.data.storage.models.CharacteristicStorage;
import com.example.quest_maker.domain.models.Characteristic;

import java.util.List;

public class DatabaseAuthorStorageImplementation implements AuthorStorageInterface {

    private Context context;

    public DatabaseAuthorStorageImplementation(Context context){
        this.context = context;
    }

    @Override
    public boolean saveCharacteristic(CharacteristicStorage characteristicStorage) {

        int savedCount;

        CharacteristicsDBAdapter characteristicsDBAdapter = new CharacteristicsDBAdapter(context);
        characteristicsDBAdapter.open();
        savedCount = characteristicsDBAdapter.updateValue(characteristicStorage.name, characteristicStorage.value);
        characteristicsDBAdapter.close();

        return savedCount == 1;
    }

    @Override
    public int getCharacteristic(CharacteristicStorage characteristicStorage) {

        int characteristicValue;

        CharacteristicsDBAdapter characteristicsDBAdapter = new CharacteristicsDBAdapter(context);
        characteristicsDBAdapter.open();
        characteristicValue = (int) characteristicsDBAdapter.getValueOf(characteristicStorage.name);
        characteristicsDBAdapter.close();

        return characteristicValue;
    }

    @Override
    public List<CharacteristicStorage> getAll(){
        CharacteristicsDBAdapter characteristicsDBAdapter = new CharacteristicsDBAdapter(context);
        characteristicsDBAdapter.open();
        List<CharacteristicStorage> list = characteristicsDBAdapter.getAllCharacteristics();
        characteristicsDBAdapter.close();

        return list;
    }

}
