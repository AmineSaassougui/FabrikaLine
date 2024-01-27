package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Repositories.ICountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CountryServiceImpl implements ICountryService {
    @Autowired
    ICountryRepository countryRepository;

    @Override
    public Country addCountry(Country country){
        return countryRepository.save(country);
    }

}
