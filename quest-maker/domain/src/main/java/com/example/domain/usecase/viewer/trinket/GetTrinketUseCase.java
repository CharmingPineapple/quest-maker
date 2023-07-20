package com.example.domain.usecase.viewer.trinket;


import com.example.domain.models.viewer.Trinket;
import com.example.domain.repository.ViewerRepositoryInterface;

import java.util.List;

public class GetTrinketUseCase {

    private final ViewerRepositoryInterface viewerRepositoryInterface;

    public GetTrinketUseCase(ViewerRepositoryInterface viewerRepositoryInterface) {
        this.viewerRepositoryInterface = viewerRepositoryInterface;
    }

    public List<Trinket> getAll(){
        return viewerRepositoryInterface.getAllTrinket();
    }



}
