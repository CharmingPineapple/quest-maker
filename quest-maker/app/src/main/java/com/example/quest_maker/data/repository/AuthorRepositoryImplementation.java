package com.example.quest_maker.data.repository;

import android.content.Context;

import com.example.quest_maker.data.database.personal.CharacteristicsDBAdapter;
import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.models.SaveCharacteristicParam;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

public class AuthorRepositoryImplementation implements AuthorRepositoryInterface {

    private Context context;

    public AuthorRepositoryImplementation(Context context){
        this.context = context;
    }


    @Override
    public boolean saveCharacteristic(SaveCharacteristicParam saveCharacteristicParam) {

        int savedCount;

        CharacteristicsDBAdapter characteristicsDBAdapter = new CharacteristicsDBAdapter(context);
        characteristicsDBAdapter.open();
        savedCount = characteristicsDBAdapter.updateValue(saveCharacteristicParam.destination, saveCharacteristicParam.value);
        characteristicsDBAdapter.close();

        return savedCount == 1;
    }

    @Override
    public short getCharacteristic(Characteristic characteristic) {

        short characteristicValue;

        CharacteristicsDBAdapter characteristicsDBAdapter = new CharacteristicsDBAdapter(context);
        characteristicsDBAdapter.open();
        characteristicValue = (short) characteristicsDBAdapter.getValueOf(characteristic.name);
        characteristicsDBAdapter.close();

        return characteristicValue;
    }

}
