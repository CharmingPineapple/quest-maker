package com.example.quest_maker.domain.usecase;

import com.example.quest_maker.domain.models.SaveCharacteristicParam;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

public class SaveCharacteristicUseCase {

    /*public boolean execute(String destination, byte value){
        if(destination.isEmpty()) return false; else return true;
    }*/

    private AuthorRepositoryInterface authorRepositoryInterface;

    public boolean execute(SaveCharacteristicParam param){
        boolean result = authorRepositoryInterface.saveCharacteristic(param);
        return result;
    }

}
