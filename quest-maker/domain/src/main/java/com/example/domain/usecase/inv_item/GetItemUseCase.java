package com.example.domain.usecase.inv_item;

import com.example.domain.models.InventoryItem;
import com.example.domain.models.PersonItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetItemUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetItemUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public List<InventoryItem> getAll(){
        return authorRepositoryInterface.getAllItem();
    }

}
