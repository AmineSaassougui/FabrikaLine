package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.UserStatus;
import com.example.fabrikaline_backend.Entities.UserStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.UserStatusServiceImpl;
import com.example.fabrikaline_backend.Services.UserStatusServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/UserStatus")
@RestController
@CrossOrigin("*")




public class UserStatusRestController implements IAbstractController<UserStatus> {
    @Autowired
    UserStatusServiceImpl userStatusService;

    @Operation(operationId = "AdvancedSearchUserStatus")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<UserStatus>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<UserStatus> result = userStatusService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadUserStatus")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<UserStatus> load(@PathVariable Long id)
    {
        UserStatus result = userStatusService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteUserStatus")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        userStatusService.delete(id);
    }

    @Operation(operationId = "SaveUserStatus")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<UserStatus> save(@RequestBody UserStatus entity) throws Exception
    {
        UserStatus result = userStatusService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllUserStatus")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<UserStatus>> saveAll(List<UserStatus> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllUserStatus")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<UserStatus>> getAll() throws Exception
    {
        List<UserStatus> result = userStatusService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
