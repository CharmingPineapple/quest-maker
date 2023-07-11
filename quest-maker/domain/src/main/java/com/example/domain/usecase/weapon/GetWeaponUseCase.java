package com.example.domain.usecase.weapon;

import com.example.domain.models.Weapon;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetWeaponUseCase {
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetWeaponUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public List<Weapon> getAllWeapon(){
        return authorRepositoryInterface.getAllWeapon();
    }

}
