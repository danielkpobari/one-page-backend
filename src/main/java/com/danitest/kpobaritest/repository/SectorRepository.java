package com.danitest.kpobaritest.repository;


import com.danitest.kpobaritest.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    Optional<Sector> findByName(String name);
}
