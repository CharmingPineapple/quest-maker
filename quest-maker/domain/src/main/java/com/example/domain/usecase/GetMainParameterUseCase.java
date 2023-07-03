package com.example.domain.usecase;

import com.example.domain.models.MainParameter;
import com.example.domain.models.Skill;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetMainParameterUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetMainParameterUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public List<MainParameter> getAll(){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        return authorRepositoryInterface.getAllMainParameter();
    }

}
