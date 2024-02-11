package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Attachment;
import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AttachmentServiceImpl;
import com.example.fabrikaline_backend.Services.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Attachment")
@RestController


public class AttachmentRestController implements IAbstractController<Attachment> {

    //region Construct

    @Autowired
    AttachmentServiceImpl attachmentService;

    @PostMapping("/add/{attachmentCategoryId}")
    public ResponseEntity<Attachment> addAndAssignItemToCategory(@RequestBody Attachment attachment, @PathVariable Long attachmentCategoryId) {
        Attachment newattachment = attachmentService.saveAndAssign(attachmentCategoryId, attachment) ;
        return new ResponseEntity<>(newattachment, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Attachment> load(Long id) {
        return null;
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
    public ResponseEntity<List<Attachment>> getAll() throws Exception {
        return null;
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
