package com.example.data.repository;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.models.CharacteristicStorage;
import com.example.domain.models.Characteristic;
import com.example.domain.models.CharacteristicList;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.ArrayList;
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
    public CharacteristicList getAll(){

        List<CharacteristicStorage> listCS = authorStorageInterface.getAll();
        CharacteristicList listC = new CharacteristicList();


        for (CharacteristicStorage one : listCS){
            listC.add(characteristicMapToDomain(one));
        }

        return listC;
    }


}
