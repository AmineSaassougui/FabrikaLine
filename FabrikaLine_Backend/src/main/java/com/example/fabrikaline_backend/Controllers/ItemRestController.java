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


public class ItemRestController implements IAbstractController<Item> {

    //region Construct

    @Autowired
    ItemServiceImpl itemService;

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<Item> addAndAssignItemToCategory(@RequestBody Item item, @PathVariable Long categoryId) {
        Item newItem = itemService.saveAndAssign(categoryId, item) ;
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);

    }



        @Override
        @GetMapping("/load/{id}")
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
    @GetMapping("/GetAll")

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
