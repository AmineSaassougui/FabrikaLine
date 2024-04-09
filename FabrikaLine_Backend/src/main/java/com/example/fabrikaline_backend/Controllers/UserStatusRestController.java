package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.UserStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.UserStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/UserStatus")
@RestController


public class UserStatusRestController implements IAbstractController<UserStatus> {

    //region Construct

    @Autowired
    UserStatusServiceImpl userStatusService;

    @GetMapping("/advancedSearch")
    public ResponseEntity<List<UserStatus>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<UserStatus> searchResults = userStatusService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    @GetMapping("/load/{id}")

    public ResponseEntity<UserStatus> load(@PathVariable Long id) {
        UserStatus status= userStatusService.getById(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/Delete/{id}")

    public void delete(@PathVariable Long id) { userStatusService.delete(id);}

    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<UserStatus> save(@RequestBody UserStatus entity) throws Exception {
        UserStatus orderStatus = userStatusService.save(entity);
        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserStatus>> saveAll(List<UserStatus> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping("/GetAll")

    public ResponseEntity<List<UserStatus>> getAll() throws Exception {
        List<UserStatus> userStatusList = userStatusService.getAll();
        return new ResponseEntity<>(userStatusList,HttpStatus.OK);
    }

}
