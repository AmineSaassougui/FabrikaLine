package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Country")
@RestController
@CrossOrigin("*")



public class CountryRestController implements IAbstractController<Country> {

    //region Construct

    @Autowired
    CountryServiceImpl countryService;

    //endregion

    //region Methods

    @Override
    @GetMapping("/load/{id}")
    public ResponseEntity<Country> load(@PathVariable Long id) {
        Country country= countryService.getById(id);
        return new ResponseEntity<>(country,HttpStatus.OK);

    }
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Country>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<Country> searchResults = countryService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        countryService.delete(id);    
    }
    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<Country> save(@RequestBody Country entity) throws Exception {
        Country res = countryService.save(entity);
        return new ResponseEntity<Country>(res, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<Country>> saveAll(List<Country> entities) throws Exception {
        return null;
    }

    @GetMapping(value = "/GetAll", produces = "application/json")
    @Override
    public ResponseEntity<List<Country>> getAll() throws Exception {
        List<Country> countries = countryService.getAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);    }

    @Override
    public ResponseEntity<List<Country>> search(SearchCriteria criteria) throws Exception {
        return null; //TODO
    }

    @Override
    public ResponseEntity<List<Country>> getAll(Long page, Long size) throws Exception {
        return null; //TODO
    }

    @Override
    public ResponseEntity<Long> count() throws Exception {
        return null; //TODO
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception {
        return null; //TODO
    }
    //endregion
}
