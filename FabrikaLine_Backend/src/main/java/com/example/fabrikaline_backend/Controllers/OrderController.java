package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Entities.Order;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AttachmentCategoryServiceImpl;
import com.example.fabrikaline_backend.Services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Order")
@RestController
@CrossOrigin("*")


public class OrderController implements IAbstractController<Order> {

    //region Construct

    @Autowired
    OrderServiceImpl orderService;


    @Override
    public ResponseEntity<Order> load(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ResponseEntity<Order> save(Order entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Order>> saveAll(List<Order> entities) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Order>> getAll() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Order>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Order>> getAll(Long page, Long size) throws Exception {
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
