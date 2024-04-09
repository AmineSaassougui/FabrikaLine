package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Attachment;
import com.example.fabrikaline_backend.Services.AttachmentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Attachment")
@RestController
@CrossOrigin("*")

public class AttachmentRestController implements IAbstractController<Attachment> {

    @Autowired
    AttachmentServiceImpl attachmentService;

    @Operation(operationId = "AdvancedSearchAttachment")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Attachment>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<Attachment> result = attachmentService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    @Operation(operationId = "LoadAttachment")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Attachment> load(@PathVariable Long id)
    {
        Attachment result = attachmentService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteAttachment")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        attachmentService.delete(id);
    }

    @Override
    public ResponseEntity<Attachment> save(Attachment entity) throws Exception {
        return null;
    }

    @Operation(operationId = "SaveAllAttachment")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<Attachment>> saveAll(List<Attachment> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllAttachment")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Attachment>> getAll() throws Exception
    {
        List<Attachment> result = attachmentService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Operation(operationId = "GetAttachmentByParentIdAttachment")
    @GetMapping(value = "/getAttachmentByParentId",  produces = "application/json")
    public ResponseEntity<List<Attachment>> getAttachmentByParentId( @RequestParam(value = "parentId",required = false) Long parentId)
  {
        try {
            List<Attachment> res = attachmentService.getAttachmenstByParentId(parentId);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(operationId = "SaveAttachment")
    @PostMapping("/Save/{attachmentCategoryId}")
    public ResponseEntity<Attachment> Save(@RequestBody Attachment attachment, @PathVariable Long attachmentCategoryId) {
        Attachment newattachment = attachmentService.saveAndAssign(attachmentCategoryId, attachment) ;
        return new ResponseEntity<>(newattachment, HttpStatus.CREATED);
    }














}
