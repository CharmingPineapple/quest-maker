package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.database.personal.adapter.CharacteristicsDBAdapter;
import com.example.data.storage.models.CharacteristicStorage;

import java.util.List;

public class DatabaseAuthorStorageImplementation implements AuthorStorageInterface {

    private Context context;

    public DatabaseAuthorStorageImplementation(Context context){
        this.context = context;
    }

    @Override
    public void saveCharacteristic(CharacteristicStorage characteristicStorage) {

        CharacteristicsDBAdapter characteristicsDBAdapter = new CharacteristicsDBAdapter(context);
        characteristicsDBAdapter.open();
        characteristicsDBAdapter.updateValue(characteristicStorage.name, characteristicStorage.value);
        characteristicsDBAdapter.close();

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

    @Override
    public void saveAll(List<CharacteristicStorage> listCS){
        CharacteristicsDBAdapter characteristicsDBAdapter = new CharacteristicsDBAdapter(context);
        characteristicsDBAdapter.open();
        characteristicsDBAdapter.saveAllCharacteristics(listCS);
        characteristicsDBAdapter.close();
    }

}
