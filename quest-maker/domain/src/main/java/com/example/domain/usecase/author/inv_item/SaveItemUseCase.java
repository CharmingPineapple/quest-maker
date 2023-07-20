package com.example.domain.usecase.author.inv_item;

import com.example.domain.models.author.InventoryItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class SaveItemUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveItemUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void saveAll(List<InventoryItem> itemList){
        authorRepositoryInterface.saveAllItem(itemList);
    }

}