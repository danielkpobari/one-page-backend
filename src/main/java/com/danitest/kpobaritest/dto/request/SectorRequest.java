package com.danitest.kpobaritest.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SectorRequest {
    @NotEmpty(message = "Sector id cannot be empty")
    @NotNull(message = "Sector id cannot be null")
    private Long id;
    @NotNull(message = "Sector name cannot be null")
    @NotEmpty(message = "Sector name cannot be empty")
    private String name;
}
