package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.CountryServiceImpl;
import com.example.fabrikaline_backend.Services.ItemCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/ItemCategory")
@RestController


public class ItemCategoryRestController implements IAbstractController<ItemCategory> {

    //region Construct

    @Autowired
    ItemCategoryServiceImpl itemCategoryService;


    @Override
    @GetMapping("/load/{id}")
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
    @GetMapping("/GetAll")

    public ResponseEntity<List<ItemCategory>> getAll() throws Exception {
        List<ItemCategory> itemCategories = itemCategoryService.getAll();
        return new ResponseEntity<>(itemCategories,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ItemCategory>> search(SearchCriteria criteria) throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<List<ItemCategory>> getAll(Long page, Long size) throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<Long> count() throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception {
        return null;//TODO
    }
}
