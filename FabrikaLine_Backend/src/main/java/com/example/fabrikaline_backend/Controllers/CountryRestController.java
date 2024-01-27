package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Services.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Country")
@RestController


public class CountryRestController {


    @Autowired
    ICountryService countryService;


    @PostMapping("/addCountry")
    @ResponseBody
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country) ;
    }
}
