package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Entities.Item;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.OrderStatusServiceImpl;
import com.example.fabrikaline_backend.Services.OrderStatusServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/OrderStatus")
@RestController
@CrossOrigin("*")



public class OrderStatusRestController implements IAbstractController<OrderStatus> {

    @Autowired
    OrderStatusServiceImpl orderStatusService;

    @Operation(operationId = "AdvancedSearchOrderStatus")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<OrderStatus>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<OrderStatus> result = orderStatusService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadOrderStatus")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<OrderStatus> load(@PathVariable Long id)
    {
        OrderStatus result = orderStatusService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteOrderStatus")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        orderStatusService.delete(id);
    }

    @Operation(operationId = "SaveOrderStatus")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<OrderStatus> save(@RequestBody OrderStatus entity) throws Exception
    {
        OrderStatus result = orderStatusService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllOrderStatus")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<OrderStatus>> saveAll(List<OrderStatus> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllOrderStatus")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<OrderStatus>> getAll() throws Exception
    {
        List<OrderStatus> result = orderStatusService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
