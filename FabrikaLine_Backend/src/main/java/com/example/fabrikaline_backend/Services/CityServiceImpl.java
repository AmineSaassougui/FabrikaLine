package com.example.fabrikaline_backend.Services;
import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Repositories.ICityRepository;
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
    public City getById(Long id) {
        return iCityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<City> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<City> listCity;

        if (searchCriteria != null )
        {
            listCity = iCityRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            listCity = iCityRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), listCity.size());
            if (fromIndex < listCity.size() && fromIndex < toIndex) {
                return listCity.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return listCity;
    }
}
