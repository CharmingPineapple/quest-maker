package com.example.domain.usecase.author.main_parameter;

import com.example.domain.models.author.PersonItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class SaveMainParameterUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveMainParameterUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void saveAll(List<PersonItem> list){
        authorRepositoryInterface.saveAllMainParameter(list);
    }

}
