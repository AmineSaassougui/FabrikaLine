package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Services.CityServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/City")
@RestController
@CrossOrigin("*")

public class CityRestController implements IAbstractController<City> {

    @Autowired
    CityServiceImpl cityService;

    @Operation(operationId = "AdvancedSearchCity")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<City>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<City> searchResults = cityService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(operationId = "AddAndAssignItemToCategoryCity")
    @PostMapping("/save/{countryId}")
    public ResponseEntity<City> addAndAssignItemToCategory(@RequestBody City city, @PathVariable Long countryId)
    {
        City result = cityService.saveAndAssign(countryId, city) ;
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    @Operation(operationId = "LoadCity")
    @GetMapping("/load/{id}")
    public ResponseEntity<City> load(@PathVariable Long id)
    {
        City result = cityService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteCity")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        cityService.delete(id);
    }

    @Override
    public ResponseEntity<City> save(City entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<City>> saveAll(List<City> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllCity")
    @GetMapping("/GetAll")
    public ResponseEntity<List<City>> getAll() throws Exception
    {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities,HttpStatus.OK);
    }



    @Operation(operationId = "GetCitiesByCountry")
    @GetMapping("/by-country/{countryId}")
    public ResponseEntity<List<City>> getAllByCountry(@PathVariable Long countryId) {
        List<City> cities = cityService.getAllByCountry(countryId);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

}
