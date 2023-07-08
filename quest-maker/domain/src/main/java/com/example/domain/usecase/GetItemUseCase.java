package com.example.domain.usecase;

import com.example.domain.models.PersonItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetItemUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetItemUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    // (!)
    public List<PersonItem> getAll(){
        return authorRepositoryInterface.getAllItem(); // getAllItem
    }

}
