package com.example.fabrikaline_backend.Repositories;

import com.example.fabrikaline_backend.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepository extends JpaRepository<Country,Long> {
}
