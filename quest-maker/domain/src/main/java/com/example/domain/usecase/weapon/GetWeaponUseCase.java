package com.example.domain.usecase.weapon;

import com.example.domain.models.Weapon;
import com.example.domain.repository.AuthorRepositoryInterface;
import com.example.domain.repository.ViewerRepositoryInterface;

import java.util.List;

public class GetWeaponUseCase {
    private final ViewerRepositoryInterface viewerRepositoryInterface;

    public GetWeaponUseCase(ViewerRepositoryInterface viewerRepositoryInterface) {
        this.viewerRepositoryInterface = viewerRepositoryInterface;
    }

    public List<Weapon> getAll(){
        return viewerRepositoryInterface.getAllWeapon();
    }

}
