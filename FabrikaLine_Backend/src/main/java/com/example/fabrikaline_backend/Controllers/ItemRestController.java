package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Item;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Item")
@RestController
@CrossOrigin("*")


public class ItemRestController implements IAbstractController<Item> {

    //region Construct

    @Autowired
    ItemServiceImpl itemService;
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Item>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<Item> searchResults = itemService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Save/{categoryId}")
    public ResponseEntity<Item> Save(@RequestBody Item item, @PathVariable Long categoryId) {
        Item newItem = itemService.saveAndAssign(categoryId, item) ;
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
        @Override
        @GetMapping(value = "/Load/{id}", produces = "application/json")
        public ResponseEntity<Item> load(@PathVariable Long id) {
            Item item = itemService.getById(id);
            return new ResponseEntity<>(item,HttpStatus.OK);

        }

    @Override
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { itemService.delete(id);}


    @Override
    public ResponseEntity<Item> save(Item entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Item>> saveAll(List<Item> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Item>> getAll() throws Exception {
        List<Item> items = itemService.getAll();
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Item>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Item>> getAll(Long page, Long size) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Long> count() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception {
        return null;
    }
}
