package com.example.quest_maker.domain.usecase;

import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

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
    public List<Characteristic> getAll(){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        return authorRepositoryInterface.getAll();
    }

}
