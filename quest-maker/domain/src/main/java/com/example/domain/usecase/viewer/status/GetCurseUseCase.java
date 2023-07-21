package com.example.domain.usecase.viewer.status;

import com.example.domain.models.viewer.Status;
import com.example.domain.repository.ViewerRepositoryInterface;

import java.util.List;

public class GetCurseUseCase {

    private final ViewerRepositoryInterface viewerRepositoryInterface;

    public GetCurseUseCase(ViewerRepositoryInterface viewerRepositoryInterface) {
        this.viewerRepositoryInterface = viewerRepositoryInterface;
    }

    public List<Status> getAll(){
        return viewerRepositoryInterface.getAllCurse();
    }

}
