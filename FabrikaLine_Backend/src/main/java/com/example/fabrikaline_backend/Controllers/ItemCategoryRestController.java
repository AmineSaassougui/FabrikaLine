package com.example.fabrikaline_backend.Controllers;
import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Services.ItemCategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ItemCategory")
@RestController
@CrossOrigin("*")


public class ItemCategoryRestController implements IAbstractController<ItemCategory> {

    @Autowired
    ItemCategoryServiceImpl itemCategoryService;

    @Operation(operationId = "AdvancedSearchItemCategory")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<ItemCategory>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<ItemCategory> result = itemCategoryService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadItemCategory")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<ItemCategory> load(@PathVariable Long id)
    {
        ItemCategory result = itemCategoryService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteItemCategory")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        itemCategoryService.delete(id);
    }

    @Operation(operationId = "SaveItemCategory")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<ItemCategory> save(@RequestBody ItemCategory entity) throws Exception
    {
        ItemCategory result = itemCategoryService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllItemCategory")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<ItemCategory>> saveAll(List<ItemCategory> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllItemCategory")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<ItemCategory>> getAll() throws Exception
    {
        List<ItemCategory> result = itemCategoryService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
