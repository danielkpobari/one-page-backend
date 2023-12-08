package com.danitest.kpobaritest.service.impl;

import com.danitest.kpobaritest.dto.request.SectorRequest;
import com.danitest.kpobaritest.dto.response.ApiResponse;
import com.danitest.kpobaritest.exception.CustomBadRequestException;
import com.danitest.kpobaritest.model.Sector;
import com.danitest.kpobaritest.repository.SectorRepository;
import com.danitest.kpobaritest.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {
    private final SectorRepository sectorRepository;

    @Override
    public ApiResponse<Sector> create(SectorRequest sectorRequest) {
        sectorRepository.findByName(sectorRequest.getName()).ifPresent(sector -> {
            throw new CustomBadRequestException(sector.getName() + " already exist!");
        });

        Sector sector = new Sector();
        sector.setName(sectorRequest.getName());

        return ApiResponse.success(sectorRepository.save(sector));
    }

    @Override
    public ApiResponse<List<Sector>> getAll() {
        return ApiResponse.success(sectorRepository.findAll());
    }
}
