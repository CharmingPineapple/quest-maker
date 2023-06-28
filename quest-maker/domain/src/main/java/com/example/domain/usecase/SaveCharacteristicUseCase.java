package com.example.domain.usecase;

import com.example.domain.models.Characteristic;
import com.example.domain.models.CharacteristicList;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;
import java.util.Objects;

public class SaveCharacteristicUseCase {

    // (?) - final ?? Why?
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveCharacteristicUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void execute(Characteristic characteristic){

        // (!) - Добавить в слой presentatin проверку,
        // что saveCharacteristicParam.value == GetCharacteristicUseCase.execute()
        // и что saveCharacteristicParam.destination и saveCharacteristicParam.value подходящее

        if (!Objects.equals(characteristic.value, ""))
            authorRepositoryInterface.saveCharacteristic(characteristic);
        else {
            characteristic.value = "0";
            authorRepositoryInterface.saveCharacteristic(characteristic);
        }
    }

    public void saveAll(List<Characteristic> list){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        authorRepositoryInterface.saveAll(list);
    }

}
