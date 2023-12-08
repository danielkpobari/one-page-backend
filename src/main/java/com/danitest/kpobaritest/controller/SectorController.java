package com.danitest.kpobaritest.controller;

import com.danitest.kpobaritest.dto.request.SectorRequest;
import com.danitest.kpobaritest.dto.response.ApiResponse;
import com.danitest.kpobaritest.model.Sector;
import com.danitest.kpobaritest.service.SectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/sector")
public class SectorController {
    private final SectorService sectorService;

    @PostMapping
    public ResponseEntity<ApiResponse<Sector>> create(@Valid @RequestBody SectorRequest sector) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sectorService.create(sector));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Sector>>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(sectorService.getAll());
    }
}
