package com.example.domain.usecase.author.status;

import com.example.domain.models.author.Item;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetPersonCurseUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetPersonCurseUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public List<Item> getAll(){
        return authorRepositoryInterface.getAllPersonCurse();
    }

}
