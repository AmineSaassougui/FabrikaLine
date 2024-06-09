package com.example.fabrikaline_backend.Services;


import com.example.fabrikaline_backend.Entities.City;

import java.util.List;

public interface ICityService {
    City saveAndAssign(Long countryId, City city);

    List<City> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;

    List<City> getAllByCountry(Long countryId);
}
