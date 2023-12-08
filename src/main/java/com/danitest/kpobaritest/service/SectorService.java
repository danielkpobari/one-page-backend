package com.danitest.kpobaritest.service;

import com.danitest.kpobaritest.dto.request.SectorRequest;
import com.danitest.kpobaritest.dto.response.ApiResponse;
import com.danitest.kpobaritest.model.Sector;
import java.util.List;

public interface SectorService {
    ApiResponse<Sector> create(SectorRequest sectorRequest);

    ApiResponse<List<Sector>> getAll();
}
