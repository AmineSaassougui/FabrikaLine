package com.example.fabrikaline_backend.Controllers;
import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.DTO.ItemWithAttachmentsDTO;
import com.example.fabrikaline_backend.Entities.Item;
import com.example.fabrikaline_backend.Services.ItemServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Item")
@RestController
@CrossOrigin("*")


public class ItemRestController implements IAbstractController<Item> {


    @Autowired
    ItemServiceImpl itemService;

    @Operation(operationId = "AdvancedSearchItem")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Item>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<Item> result = itemService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadItem")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Item> load(@PathVariable Long id)
    {
        Item result = itemService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteItem")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        itemService.delete(id);
    }

    @Operation(operationId = "SaveItem")
    @PostMapping("/Save/{categoryId}")
    public ResponseEntity<Item> Save(@RequestBody Item item, @PathVariable Long categoryId) {
        Item newItem = itemService.saveAndAssign(categoryId, item) ;
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }



    @Operation(operationId = "SaveAllItem")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<Item>> saveAll(List<Item> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllItem")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Item>> getAll() throws Exception
    {
        List<Item> result = itemService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Operation(operationId = "GetAllItemsWithAttachmentsItem")
    @GetMapping(value = "/withAttachments", produces = "application/json")
    public ResponseEntity<List<ItemWithAttachmentsDTO>> getAllItemsWithAttachments(@RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) throws Exception {
        List<ItemWithAttachmentsDTO> itemsWithAttachments = itemService.getAllItemsWithAttachments(searchCriteria);
        return new ResponseEntity<>(itemsWithAttachments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> save(Item entity) throws Exception {
        return null;
    }
}
