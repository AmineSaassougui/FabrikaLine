package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICityRepository extends JpaRepository<City,Long> {
    List<City> findByDescriptionContaining(String description);
}
