package com.example.domain.usecase;

import com.example.domain.models.Characteristic;
import com.example.domain.models.CharacteristicList;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetCharacteristicUseCase {

    // (?) - final ?? Why?
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetCharacteristicUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public String execute(Characteristic characteristic){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        int value = authorRepositoryInterface.getCharacteristic(characteristic);

        // (#)
        if (value >= 0)
            return Integer.toString(value);
        else
            return "v<0";   // (!) - Один раз возвращает верное значение, а потом только "lol"
    }

    // (#)
    public CharacteristicList getAll(){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        return authorRepositoryInterface.getAll();
    }

}
