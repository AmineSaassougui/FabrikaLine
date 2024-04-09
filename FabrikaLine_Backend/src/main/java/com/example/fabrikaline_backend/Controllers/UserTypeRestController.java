package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.UserType;
import com.example.fabrikaline_backend.Entities.UserType;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.UserTypeServiceImpl;
import com.example.fabrikaline_backend.Services.UserTypeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(operationId = "AdvancedSearchUserType")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<UserType>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<UserType> result = userTypeService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadUserType")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<UserType> load(@PathVariable Long id)
    {
        UserType result = userTypeService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteUserType")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        userTypeService.delete(id);
    }

    @Operation(operationId = "SaveUserType")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<UserType> save(@RequestBody UserType entity) throws Exception
    {
        UserType result = userTypeService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllUserType")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<UserType>> saveAll(List<UserType> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllUserType")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<UserType>> getAll() throws Exception
    {
        List<UserType> result = userTypeService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
