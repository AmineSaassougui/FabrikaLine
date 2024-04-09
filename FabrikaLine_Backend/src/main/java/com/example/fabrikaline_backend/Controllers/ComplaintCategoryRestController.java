package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import com.example.fabrikaline_backend.Services.ComplaintCategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ComplaintCategory")
@RestController
public class ComplaintCategoryRestController implements IAbstractController<ComplaintCategory> {

    @Autowired
    ComplaintCategoryServiceImpl complaintCategoryService;

    @Operation(operationId = "AdvancedSearchComplaintCategory")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<ComplaintCategory>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<ComplaintCategory> result = complaintCategoryService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadComplaintCategory")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<ComplaintCategory> load(@PathVariable Long id)
    {
        ComplaintCategory result = complaintCategoryService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteComplaintCategory")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        complaintCategoryService.delete(id);
    }

    @Operation(operationId = "SaveComplaintCategory")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<ComplaintCategory> save(@RequestBody ComplaintCategory entity) throws Exception
    {
        ComplaintCategory result = complaintCategoryService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllComplaintCategory")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<ComplaintCategory>> saveAll(List<ComplaintCategory> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllComplaintCategory")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<ComplaintCategory>> getAll() throws Exception
    {
        List<ComplaintCategory> result = complaintCategoryService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
