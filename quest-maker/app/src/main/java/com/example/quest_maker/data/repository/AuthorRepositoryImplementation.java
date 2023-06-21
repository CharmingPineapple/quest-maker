package com.example.quest_maker.data.repository;

import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.models.SaveCharacteristicParam;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

public class AuthorRepositoryImplementation implements AuthorRepositoryInterface {

    @Override
    public boolean saveCharacteristic(SaveCharacteristicParam param) {

        // добавить логику сохранения
        return true;
    }

    @Override
    public byte getCharacteristic(Characteristic param) {

        // добавить логику получения значения навыка
        return 1;
    }

}
