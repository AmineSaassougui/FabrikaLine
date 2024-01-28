package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Repositories.ICountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CountryServiceImpl implements ICountryService, IAbstractService<Country> {
    @Autowired
    ICountryRepository countryRepository;


    @Override
    public Country save(Country entity) throws Exception {
        return countryRepository.save(entity);
    }

    @Override
    public void delete(int id) {

    }
}
