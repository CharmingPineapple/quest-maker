package com.example.domain.usecase.author.status_item;

import com.example.domain.models.author.Item;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetInventoryItemUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetInventoryItemUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public List<Item> getAll(){
        return authorRepositoryInterface.getAllInventoryItem();
    }

}
