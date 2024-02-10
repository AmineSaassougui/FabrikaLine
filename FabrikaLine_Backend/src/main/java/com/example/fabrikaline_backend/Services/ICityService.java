package com.example.fabrikaline_backend.Services;


import com.example.fabrikaline_backend.Entities.City;

public interface ICityService {
    City saveAndAssign(Long countryId, City city);
}
