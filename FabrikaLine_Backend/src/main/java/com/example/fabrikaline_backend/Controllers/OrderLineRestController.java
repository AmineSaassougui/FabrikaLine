package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Entities.OrderLine;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AttachmentCategoryServiceImpl;
import com.example.fabrikaline_backend.Services.OrderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/OrderLine")
@RestController
@CrossOrigin("*")


public class OrderLineRestController implements IAbstractController<OrderLine> {

    //region Construct

    @Autowired
    OrderLineServiceImpl orderLineService ;


    @Override
    public ResponseEntity<OrderLine> load(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResponseEntity<OrderLine> save(OrderLine entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderLine>> saveAll(List<OrderLine> entities) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderLine>> getAll() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderLine>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderLine>> getAll(Long page, Long size) throws Exception {
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
