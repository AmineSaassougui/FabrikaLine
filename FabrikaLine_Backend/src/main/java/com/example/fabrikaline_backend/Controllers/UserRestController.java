package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.User;
import com.example.fabrikaline_backend.Entities.User;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.UserServiceImpl;
import com.example.fabrikaline_backend.Services.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/User")
@RestController
@CrossOrigin("*")


public class UserRestController implements IAbstractController<User> {
    @Autowired
    UserServiceImpl userService;

    @Operation(operationId = "AdvancedSearchUser")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<User>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<User> result = userService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadUser")
    @ResponseBody
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<User> load(@PathVariable Long id)
    {
        User result = userService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteUser")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        userService.delete(id);
    }

    @Override
    public ResponseEntity<User> save(@RequestBody User entity) throws Exception
    {
        User result = userService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllUser")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<User>> saveAll(List<User> entities) throws Exception
    {
        return null;
    }

    @Override
    @ResponseBody
    @Operation(operationId = "GetAllUser")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<User>> getAll() throws Exception
    {
        List<User> result = userService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Operation(operationId = "SaveUser")
    @PostMapping("/save/{country_id}/{city_id}/{userstatus_id}/{usergender_id}/{usertype_id}")
    public ResponseEntity<User> addAndAssignUser(@RequestBody User user,@PathVariable Long country_id, @PathVariable Long city_id,@PathVariable Long userstatus_id,@PathVariable Long usergender_id,@PathVariable Long usertype_id) {
        User result = userService.saveAndAssign(usertype_id,usergender_id,userstatus_id,city_id,country_id,user) ;
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
