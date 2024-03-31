package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Attachment;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Attachment")
@RestController
@CrossOrigin("*")

public class AttachmentRestController implements IAbstractController<Attachment> {

    //region Construct

    @Autowired
    AttachmentServiceImpl attachmentService;

    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Attachment>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<Attachment> searchResults = attachmentService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


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

    @PostMapping("/Save/{attachmentCategoryId}")
    public ResponseEntity<Attachment> Save(@RequestBody Attachment attachment, @PathVariable Long attachmentCategoryId) {
        Attachment newattachment = attachmentService.saveAndAssign(attachmentCategoryId, attachment) ;
        return new ResponseEntity<>(newattachment, HttpStatus.CREATED);
    }


    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Attachment> load(@PathVariable Long id) {
        Attachment attachment= attachmentService.getById(id);
        return new ResponseEntity<>(attachment,HttpStatus.OK);

    }

    @Override
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { attachmentService.delete(id);}


    @Override
    public ResponseEntity<Attachment> save(Attachment entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Attachment>> saveAll(List<Attachment> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Attachment>> getAll() throws Exception {
        List<Attachment> attachments = attachmentService.getAll();
        return new ResponseEntity<>(attachments,HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<Attachment>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Attachment>> getAll(Long page, Long size) throws Exception {
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
