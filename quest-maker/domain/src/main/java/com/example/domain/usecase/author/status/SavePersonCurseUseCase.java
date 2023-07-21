package com.example.domain.usecase.author.status;

import com.example.domain.models.author.Item;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class SavePersonCurseUseCase {

    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SavePersonCurseUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void saveAll(List<Item> itemList) {
        authorRepositoryInterface.saveAllPersonCurse(itemList);
    }
}
