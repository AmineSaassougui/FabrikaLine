package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.ICityRepository;
import com.example.fabrikaline_backend.Repositories.ICountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class CityServiceImpl implements ICityService, IAbstractService<City> {
    @Autowired
    ICityRepository iCityRepository;
    @Autowired
    ICountryRepository iCountryRepository;


    @Override
    public City saveAndAssign(Long countryId, City city){
        Country country = iCountryRepository.findById(countryId) .orElseThrow(() -> new IllegalArgumentException("Invalid country Id"));
        city.setCountry(country);
        return iCityRepository.save(city);
    }


    @Override
    public City save(City entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) { iCityRepository.deleteById(id);}

    @Override
    public List<City> getAll() {
        return iCityRepository.findAll() ;
    }

    @Override
    public List<City> saveAll(List<City> entities) throws Exception {
        return null;
    }

    @Override
    public List<City> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(City entity) throws ValidationException {

    }

    @Override
    public City getById(Long id) {
        return null;
    }
}
