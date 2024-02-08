package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AttachmentCategoryServiceImpl;
import com.example.fabrikaline_backend.Services.OrderStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/OrderStatus")
@RestController


public class OrderStatusRestController implements IAbstractController<OrderStatus> {

    //region Construct

    @Autowired
    OrderStatusServiceImpl orderStatusService;


    @Override
    public ResponseEntity<OrderStatus> load(Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/Delete/{id}")

    public void delete(@PathVariable Long id) { orderStatusService.delete(id);}

    @PostMapping("/Save")
    @ResponseBody
    @Override
    public ResponseEntity<OrderStatus> save(@RequestBody OrderStatus entity) throws Exception {
        OrderStatus orderStatus = orderStatusService.save(entity);
        return new ResponseEntity<>(orderStatus, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderStatus>> saveAll(List<OrderStatus> entities) throws Exception {
        return null;
    }

    @Override
    @GetMapping("/GetAll")

    public ResponseEntity<List<OrderStatus>> getAll() throws Exception {
        List<OrderStatus> orderStatusList = orderStatusService.getAll();
        return new ResponseEntity<>(orderStatusList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OrderStatus>> search(SearchCriteria criteria) throws Exception {
        return null;//TODO
    }

    @Override
    public ResponseEntity<List<OrderStatus>> getAll(Long page, Long size) throws Exception {
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
