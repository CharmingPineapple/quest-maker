package com.example.domain.usecase;

import com.example.domain.models.PersonItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class SaveMainParameterUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveMainParameterUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void saveAll(List<PersonItem> list){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        authorRepositoryInterface.saveAllMainParameter(list);
    }

}
