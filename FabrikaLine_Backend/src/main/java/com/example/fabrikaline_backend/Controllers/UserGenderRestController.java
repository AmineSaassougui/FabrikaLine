package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.UserGender;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.UserGenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/UserGender")
@RestController
@CrossOrigin("*")

public class UserGenderRestController implements IAbstractController<UserGender> {

    //region Construct

    @Autowired
    UserGenderServiceImpl userGenderService;

    //endregion

    //region Methods
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    @Override
    public ResponseEntity<UserGender> load(@PathVariable Long id) {
        UserGender userGender = userGenderService.getById(id);
        return new ResponseEntity<UserGender>(userGender, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        userGenderService.delete(id);
    }
    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<UserGender> save(@RequestBody UserGender entity) throws Exception {
        UserGender userGender = userGenderService.save(entity);
        return new ResponseEntity<UserGender>(userGender, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<UserGender>> saveAll(List<UserGender> entities) throws Exception {
        return null;
    }
    @GetMapping(value = "/GetAll", produces = "application/json")
    @Override
    public ResponseEntity<List<UserGender>> getAll() throws Exception {
        List<UserGender> userGenders = userGenderService.getAll();
        return new ResponseEntity<>(userGenders, HttpStatus.OK);    }

    @Override
    public ResponseEntity<List<UserGender>> search(SearchCriteria criteria) throws Exception {
        return null; //TODO
    }

    @Override
    public ResponseEntity<List<UserGender>> getAll(Long page, Long size) throws Exception {
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
