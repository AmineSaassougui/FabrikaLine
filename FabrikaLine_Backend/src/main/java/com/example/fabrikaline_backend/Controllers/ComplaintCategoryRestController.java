package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.ComplaintCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ComplaintCategory")
@RestController


public class ComplaintCategoryRestController implements IAbstractController<ComplaintCategory> {

    //region Construct

    @Autowired
    ComplaintCategoryServiceImpl complaintCategoryService;


    @Override
    @GetMapping("/load/{id}")

    public ResponseEntity<ComplaintCategory> load(@PathVariable  Long id) {
        ComplaintCategory category = complaintCategoryService.getById(id);
        return new ResponseEntity<>(category,HttpStatus.OK);

    }

    @Override
    @DeleteMapping("/Delete/{id}")

    public void delete(@PathVariable Long id) { complaintCategoryService.delete(id);}

    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<ComplaintCategory> save(@RequestBody ComplaintCategory entity) throws Exception {
        ComplaintCategory complaintCategory = complaintCategoryService.save(entity);
        return new ResponseEntity<>(complaintCategory, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ComplaintCategory>> saveAll(List<ComplaintCategory> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping("/GetAll")

    public ResponseEntity<List<ComplaintCategory>> getAll() throws Exception {
        List<ComplaintCategory> complaintCategories = complaintCategoryService.getAll();
        return new ResponseEntity<>(complaintCategories,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ComplaintCategory>> search(SearchCriteria criteria) throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<List<ComplaintCategory>> getAll(Long page, Long size) throws Exception {
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
