package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.UserGender;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Entities.UserGender;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.UserGenderServiceImpl;
import com.example.fabrikaline_backend.Services.UserGenderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/UserGender")
@RestController
@CrossOrigin("*")

public class UserGenderRestController implements IAbstractController<UserGender> {
    @Autowired
    UserGenderServiceImpl userGenderService;

    @Operation(operationId = "AdvancedSearchUserGender")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<UserGender>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<UserGender> result = userGenderService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadUserGender")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<UserGender> load(@PathVariable Long id)
    {
        UserGender result = userGenderService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteUserGender")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        userGenderService.delete(id);
    }

    @Operation(operationId = "SaveUserGender")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<UserGender> save(@RequestBody UserGender entity) throws Exception
    {
        UserGender result = userGenderService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllUserGender")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<UserGender>> saveAll(List<UserGender> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllUserGender")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<UserGender>> getAll() throws Exception
    {
        List<UserGender> result = userGenderService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
