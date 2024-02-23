package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Models.SearchCriteria;

import java.util.List;

public interface ICountryService  {
    List<Country> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
