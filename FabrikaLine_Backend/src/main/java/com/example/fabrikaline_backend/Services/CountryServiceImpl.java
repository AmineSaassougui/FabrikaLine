package com.example.fabrikaline_backend.Services;
import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Repositories.ICountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Collections;
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
    public Country getById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<Country> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<Country> listCountry;

        if (searchCriteria != null )
        {
            listCountry = countryRepository.findByDescriptionContaining(searchCriteria);
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            listCountry = countryRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), listCountry.size());
            if (fromIndex < listCountry.size() && fromIndex < toIndex) {
                return listCountry.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
    return listCountry;
    }



}
