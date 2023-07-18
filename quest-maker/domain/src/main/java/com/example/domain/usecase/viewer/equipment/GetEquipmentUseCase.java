package com.example.domain.usecase.viewer.equipment;

import com.example.domain.models.viewer.Equipment;
import com.example.domain.repository.ViewerRepositoryInterface;

import java.util.List;

public class GetEquipmentUseCase {

    private final ViewerRepositoryInterface viewerRepositoryInterface;

    public GetEquipmentUseCase(ViewerRepositoryInterface viewerRepositoryInterface) {
        this.viewerRepositoryInterface = viewerRepositoryInterface;
    }

    public List<Equipment> getAll(){
        return viewerRepositoryInterface.getAllEquipment();
    }


}
