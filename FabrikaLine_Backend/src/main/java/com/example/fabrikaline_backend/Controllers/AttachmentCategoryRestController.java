package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AttachmentCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/AttachmentCategory")
@RestController


public class AttachmentCategoryRestController implements IAbstractController<AttachmentCategory> {

    //region Construct

    @Autowired
    AttachmentCategoryServiceImpl attachmentCategoryService;


    @Override
    @GetMapping("/load/{id}")
    public ResponseEntity<AttachmentCategory> load(Long id) {
        AttachmentCategory category = attachmentCategoryService.getById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }


    @Override
    @DeleteMapping("/Delete/{id}")

    public void delete(@PathVariable Long id) { attachmentCategoryService.delete(id);}

    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<AttachmentCategory> save(@RequestBody AttachmentCategory entity) throws Exception {
        AttachmentCategory attachmentCategory = attachmentCategoryService.save(entity);
        return new ResponseEntity<>(attachmentCategory, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AttachmentCategory>> saveAll(List<AttachmentCategory> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping("/GetAll")

    public ResponseEntity<List<AttachmentCategory>> getAll() throws Exception {
        List<AttachmentCategory> attachmentCategories = attachmentCategoryService.getAll();
        return new ResponseEntity<>(attachmentCategories,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AttachmentCategory>> search(SearchCriteria criteria) throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<List<AttachmentCategory>> getAll(Long page, Long size) throws Exception {
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
