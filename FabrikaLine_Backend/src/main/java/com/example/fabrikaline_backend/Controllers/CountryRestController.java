package com.example.fabrikaline_backend.Controllers;
import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Services.CountryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Country")
@RestController
@CrossOrigin("*")
public class CountryRestController implements IAbstractController<Country> {

    @Autowired
    CountryServiceImpl countryService;

    @Operation(operationId = "AdvancedSearchCountry")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Country>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<Country> result = countryService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadCountry")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Country> load(@PathVariable Long id)
    {
        Country result = countryService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteCountry")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        countryService.delete(id);
    }

    @Operation(operationId = "SaveCountry")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<Country> save(@RequestBody Country entity) throws Exception
    {
        Country result = countryService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllCountry")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<Country>> saveAll(List<Country> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllCountry")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Country>> getAll() throws Exception
    {
        List<Country> result = countryService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
