package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.UserType;
import com.example.fabrikaline_backend.Models.SearchCriteria;
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

    @GetMapping("/advancedSearch")
    public ResponseEntity<List<UserType>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<UserType> searchResults = userTypeService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    @GetMapping("/load/{id}")
    public ResponseEntity<UserType> load(@PathVariable Long id) {
        UserType type= userTypeService.getById(id);
        return new ResponseEntity<>(type,HttpStatus.OK);
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

}
