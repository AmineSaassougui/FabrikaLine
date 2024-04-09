package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Order;
import com.example.fabrikaline_backend.Services.OrderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Order")
@RestController
@CrossOrigin("*")


public class OrderController implements IAbstractController<Order> {
    
    @Autowired
    OrderServiceImpl orderService;

    @Operation(operationId = "AdvancedSearchOrder")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Order>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<Order> result = orderService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadOrder")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Order> load(@PathVariable Long id)
    {
        Order result = orderService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteOrder")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        orderService.delete(id);
    }

    @Operation(operationId = "SaveOrder")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<Order> save(@RequestBody Order entity) throws Exception
    {
        Order result = orderService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllOrder")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<Order>> saveAll(List<Order> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllOrder")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Order>> getAll() throws Exception
    {
        List<Order> result = orderService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
