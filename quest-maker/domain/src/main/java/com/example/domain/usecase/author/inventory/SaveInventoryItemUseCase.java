package com.example.domain.usecase.author.inventory;

import com.example.domain.models.author.Item;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class SaveInventoryItemUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveInventoryItemUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void saveAll(List<Item> itemList){
        authorRepositoryInterface.saveAllInventoryItem(itemList);
    }

}
