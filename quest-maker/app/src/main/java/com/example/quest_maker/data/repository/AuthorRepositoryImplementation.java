package com.example.quest_maker.data.repository;

import com.example.quest_maker.data.storage.AuthorStorageInterface;
import com.example.quest_maker.data.storage.database.personal.adapter.CharacteristicsDBAdapter;
import com.example.quest_maker.data.storage.models.CharacteristicStorage;
import com.example.quest_maker.domain.models.Characteristic;
import com.example.quest_maker.domain.repository.AuthorRepositoryInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthorRepositoryImplementation implements AuthorRepositoryInterface {

    private AuthorStorageInterface authorStorageInterface;

    public AuthorRepositoryImplementation(AuthorStorageInterface authorStorageInterface){
        this.authorStorageInterface = authorStorageInterface;
    }


    @Override
    public boolean saveCharacteristic(Characteristic characteristic) {
        return authorStorageInterface.saveCharacteristic(characteristicMapToStorage(characteristic));
    }

    @Override
    public int getCharacteristic(Characteristic characteristic) {
        return authorStorageInterface.getCharacteristic(characteristicMapToStorage(characteristic));
    }

    private CharacteristicStorage characteristicMapToStorage(Characteristic characteristic){
        return new CharacteristicStorage(characteristic.name, Integer.parseInt(characteristic.value));
    }

    private Characteristic characteristicMapToDomain(CharacteristicStorage characteristicStorage){
        return new Characteristic(characteristicStorage.name, Integer.toString(characteristicStorage.value));
    }

    // (#)
    public List<Characteristic> getAll(){

        List<CharacteristicStorage> listCS = authorStorageInterface.getAll();
        List<Characteristic> listC = new ArrayList<>();


        for (CharacteristicStorage one : listCS){
            listC.add(characteristicMapToDomain(one));
        }

        return listC;
    }


}
