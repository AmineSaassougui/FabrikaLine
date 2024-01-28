package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.CountryServiceImpl;
import com.example.fabrikaline_backend.Services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Country")
@RestController


public class CountryRestController implements IAbstractController<Country> {

    //region Construct

    @Autowired
    CountryServiceImpl countryService;

    //endregion

    //region Methods

    @Override
    public ResponseEntity<Country> load(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
    @PostMapping("/addCountry")
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

    @Override
    public ResponseEntity<List<Country>> getAll() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Country> update(int id, Country entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Country>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Country>> getAll(int page, int size) throws Exception {
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
    //endregion
}
