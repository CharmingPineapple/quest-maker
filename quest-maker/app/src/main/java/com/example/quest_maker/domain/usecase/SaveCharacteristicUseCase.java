package com.example.quest_maker.domain.usecase;

import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

import java.util.Objects;

public class SaveCharacteristicUseCase {

    // (?) - final ?? Why?
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveCharacteristicUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public boolean execute(Characteristic characteristic){

        // (!) - Добавить в слой presentatin проверку,
        // что saveCharacteristicParam.value == GetCharacteristicUseCase.execute()
        // и что saveCharacteristicParam.destination и saveCharacteristicParam.value подходящее

        if (!Objects.equals(characteristic.value, ""))
            return authorRepositoryInterface.saveCharacteristic(characteristic);
        else {
            characteristic.value = "0";
            return authorRepositoryInterface.saveCharacteristic(characteristic);
        }

    }

}
