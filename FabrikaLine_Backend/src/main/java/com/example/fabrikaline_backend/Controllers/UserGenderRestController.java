package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.OrderStatus;
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

    @GetMapping("/advancedSearch")
    public ResponseEntity<List<UserGender>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<UserGender> searchResults = userGenderService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        return null;
    }
    @GetMapping(value = "/AdvancedSearch/{currentPosition}/{step}", produces = "application/json")
    public ResponseEntity<List<UserGender>> advancedSearch(@PathVariable Long currentPosition, @PathVariable Long step) throws Exception {
//        // Check if currentPosition is provided
//        if (currentPosition == null || currentPosition < 0) {
//            currentPosition = 0L; // Default to start from the beginning
//        }

        // Check if step is provided
//        if (step == null || step <= 0) {
//            step = 10L; // Default to step of 1
//        }

        // Calculate offset based on currentPosition and step
        long offset = currentPosition * step;

        // Query items from database using offset and size
        List<UserGender> items = userGenderService.advancedSearch(offset, step);

        // Return paginated items in ResponseEntity
        return ResponseEntity.ok().body(items);
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
