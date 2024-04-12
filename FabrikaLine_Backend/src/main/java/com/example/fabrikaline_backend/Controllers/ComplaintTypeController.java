package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.ComplaintType;
import com.example.fabrikaline_backend.Services.ComplaintTypeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ComplaintType")
@RestController
@CrossOrigin("*")


public class ComplaintTypeController implements IAbstractController<ComplaintType> {
    
    @Autowired
    ComplaintTypeServiceImpl complaintTypeService;

    @Operation(operationId = "AdvancedSearchComplaintType")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<ComplaintType>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<ComplaintType> result = complaintTypeService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadComplaintType")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<ComplaintType> load(@PathVariable Long id)
    {
        ComplaintType result = complaintTypeService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteComplaintType")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        complaintTypeService.delete(id);
    }

    @Override
    public ResponseEntity<ComplaintType> save(@RequestBody ComplaintType entity) throws Exception
    {
        ComplaintType result = complaintTypeService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @Operation(operationId = "SaveComplaintType")
    @PostMapping("/save/{complaintcategory_id}")
    public ResponseEntity<ComplaintType> addAndAssignUser(@RequestBody ComplaintType complaintType, @PathVariable Long complaintcategory_id) {
        ComplaintType result = complaintTypeService.saveAndAssign(complaintcategory_id,complaintType) ;
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Operation(operationId = "SaveAllComplaintType")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<ComplaintType>> saveAll(List<ComplaintType> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllComplaintType")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<ComplaintType>> getAll() throws Exception
    {
        List<ComplaintType> result = complaintTypeService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
