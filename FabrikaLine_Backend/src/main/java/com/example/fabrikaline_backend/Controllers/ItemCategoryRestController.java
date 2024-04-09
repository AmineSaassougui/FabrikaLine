package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.ItemCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/ItemCategory")
@RestController
@CrossOrigin("*")


public class ItemCategoryRestController implements IAbstractController<ItemCategory> {

    //region Construct

    @Autowired
    ItemCategoryServiceImpl itemCategoryService;


    @GetMapping("/advancedSearch")
    public ResponseEntity<List<ItemCategory>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<ItemCategory> searchResults = itemCategoryService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<ItemCategory> load(@PathVariable Long id) {
        ItemCategory category= itemCategoryService.getById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);

    }

    @Override
    @DeleteMapping("/Delete/{id}")

    public void delete(@PathVariable Long id) { itemCategoryService.delete(id);}

    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<ItemCategory> save(@RequestBody ItemCategory entity) throws Exception {
        ItemCategory itemCategory = itemCategoryService.save(entity);
        return new ResponseEntity<>(itemCategory, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ItemCategory>> saveAll(List<ItemCategory> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<ItemCategory>> getAll() throws Exception {
        List<ItemCategory> itemCategories = itemCategoryService.getAll();
        return new ResponseEntity<>(itemCategories,HttpStatus.OK);
    }

}
