package com.example.domain.usecase.main_parameter;

import com.example.domain.models.PersonItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetMainParameterUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetMainParameterUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public List<PersonItem> getAll(){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        return authorRepositoryInterface.getAllMainParameter();
    }

}
