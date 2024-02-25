package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/City")
@RestController


public class CityRestController implements IAbstractController<City> {

    //region Construct

    @Autowired
    CityServiceImpl cityService;

    @GetMapping("/advancedSearch")
    public ResponseEntity<List<City>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<City> searchResults = cityService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save/{countryId}")
    public ResponseEntity<City> addAndAssignItemToCategory(@RequestBody City city, @PathVariable Long countryId) {
        City newcity = cityService.saveAndAssign(countryId, city) ;
        return new ResponseEntity<>(newcity, HttpStatus.CREATED);
    }



    @Override
    @GetMapping("/load/{id}")
    public ResponseEntity<City> load(@PathVariable Long id) {
        City city = cityService.getById(id);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { cityService.delete(id);}


    @Override
    public ResponseEntity<City> save(City entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<City>> saveAll(List<City> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping("/GetAll")

    public ResponseEntity<List<City>> getAll() throws Exception {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities,HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<City>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<City>> getAll(Long page, Long size) throws Exception {
        return null;
    }


    @Override
    public ResponseEntity<Long> count() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception {
        return null;
    }
}
