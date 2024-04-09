package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Services.AttachmentCategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/AttachmentCategory")
@RestController
@CrossOrigin("*")


public class AttachmentCategoryRestController implements IAbstractController<AttachmentCategory> {
    @Autowired
    AttachmentCategoryServiceImpl attachmentCategoryService;

    @Operation(operationId = "AdvancedSearchAttachmentCategory")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<AttachmentCategory>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<AttachmentCategory> result = attachmentCategoryService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadAttachmentCategory")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<AttachmentCategory> load(@PathVariable Long id)
    {
        AttachmentCategory result = attachmentCategoryService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteAttachmentCategory")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        attachmentCategoryService.delete(id);
    }

    @Operation(operationId = "SaveAttachmentCategory")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<AttachmentCategory> save(@RequestBody AttachmentCategory entity) throws Exception
    {
        AttachmentCategory result = attachmentCategoryService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllAttachmentCategory")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<AttachmentCategory>> saveAll(List<AttachmentCategory> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllAttachmentCategory")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<AttachmentCategory>> getAll() throws Exception
    {
        List<AttachmentCategory> result = attachmentCategoryService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
