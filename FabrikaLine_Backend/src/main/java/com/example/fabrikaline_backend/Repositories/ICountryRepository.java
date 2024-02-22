package com.example.fabrikaline_backend.Repositories;

import com.example.fabrikaline_backend.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICountryRepository extends JpaRepository<Country,Long> {
    List<Country> findByDescriptionContaining(String description);
}
