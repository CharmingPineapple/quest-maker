package com.example.quest_maker.domain.usecase;

import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

public class GetCharacteristicUseCase {


    private AuthorRepositoryInterface authorRepositoryInterface;

    private short result = 1;

    public short execute(Characteristic param){

        return authorRepositoryInterface.getCharacteristic(param);

        //return result;
    }

}
