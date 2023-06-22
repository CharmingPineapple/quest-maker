package com.example.quest_maker.domain.usecase;

import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

public class GetCharacteristicUseCase {

    // (?) - final ?? Why?
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetCharacteristicUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public short execute(Characteristic characteristic){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        return authorRepositoryInterface.getCharacteristic(characteristic);
    }

}
