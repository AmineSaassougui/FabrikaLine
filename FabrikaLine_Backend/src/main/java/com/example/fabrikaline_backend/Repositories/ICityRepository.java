package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City,Long> {
}
