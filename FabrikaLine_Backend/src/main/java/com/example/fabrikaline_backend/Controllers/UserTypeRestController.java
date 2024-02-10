package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Entities.UserType;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.ItemCategoryServiceImpl;
import com.example.fabrikaline_backend.Services.UserTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/UserType")
@RestController


public class UserTypeRestController implements IAbstractController<UserType> {


    @Autowired
    UserTypeServiceImpl userTypeService;


    @Override
    public ResponseEntity<UserType> load(Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/Delete/{id}")

    public void delete(@PathVariable Long id) { userTypeService.delete(id);}

    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<UserType> save(@RequestBody UserType entity) throws Exception {
        UserType userType = userTypeService.save(entity);
        return new ResponseEntity<>(userType, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserType>> saveAll(List<UserType> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping("/GetAll")

    public ResponseEntity<List<UserType>> getAll() throws Exception {
        List<UserType> userTypes = userTypeService.getAll();
        return new ResponseEntity<>(userTypes,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserType>> search(SearchCriteria criteria) throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<List<UserType>> getAll(Long page, Long size) throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<Long> count() throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception {
        return null;//TODO
    }
}
