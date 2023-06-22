package com.example.quest_maker.domain.usecase;

import com.example.quest_maker.domain.models.SaveCharacteristicParam;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

public class SaveCharacteristicUseCase {

    // (?) - final ?? Why?
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveCharacteristicUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public boolean execute(SaveCharacteristicParam saveCharacteristicParam){

        // (!) - Добавить в слой presentatin проверку,
        // что saveCharacteristicParam.value == GetCharacteristicUseCase.execute()
        // и что saveCharacteristicParam.destination и saveCharacteristicParam.value подходящее

        boolean result = authorRepositoryInterface.saveCharacteristic(saveCharacteristicParam);
        return result;
    }

}
