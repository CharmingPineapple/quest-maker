package com.example.domain.usecase.author.status_item;

import com.example.domain.models.author.Item;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class SavePersonInjuryUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SavePersonInjuryUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void saveAll(List<Item> itemList){
        authorRepositoryInterface.saveAllPersonInjury(itemList);
    }

}
