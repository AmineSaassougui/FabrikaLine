package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.ICountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.List;

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
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> saveAll(List<Country> entities) throws Exception {
        return null; //TODO
    }

    @Override
    public List<Country> search(SearchCriteria criteria) {
        return null; //TODO
    }

    @Override
    public long count() {
        return 0;  //TODO
    }

    @Override
    public void validate(Country entity) throws ValidationException {
        //TODO
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }
}
