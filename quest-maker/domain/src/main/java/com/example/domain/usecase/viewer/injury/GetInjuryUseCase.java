package com.example.domain.usecase.viewer.injury;

import com.example.domain.models.viewer.Equipment;
import com.example.domain.models.viewer.Injury;
import com.example.domain.repository.ViewerRepositoryInterface;

import java.util.List;

public class GetInjuryUseCase {

    private final ViewerRepositoryInterface viewerRepositoryInterface;

    public GetInjuryUseCase(ViewerRepositoryInterface viewerRepositoryInterface) {
        this.viewerRepositoryInterface = viewerRepositoryInterface;
    }

    public List<Injury> getAll(){
        return viewerRepositoryInterface.getAllInjury();
    }

}
