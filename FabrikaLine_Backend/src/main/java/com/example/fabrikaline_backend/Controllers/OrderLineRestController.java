package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.OrderLine;
import com.example.fabrikaline_backend.Entities.OrderLine;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.OrderLineServiceImpl;
import com.example.fabrikaline_backend.Services.OrderLineServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/OrderLine")
@RestController
@CrossOrigin("*")


public class OrderLineRestController implements IAbstractController<OrderLine> {

    @Autowired
    OrderLineServiceImpl orderLineService;

    @Operation(operationId = "AdvancedSearchOrderLine")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<OrderLine>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<OrderLine> result = orderLineService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadOrderLine")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<OrderLine> load(@PathVariable Long id)
    {
        OrderLine result = orderLineService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteOrderLine")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        orderLineService.delete(id);
    }

    @Operation(operationId = "SaveOrderLine")
    @PostMapping("/Save")
    @Override
    public ResponseEntity<OrderLine> save(@RequestBody OrderLine entity) throws Exception
    {
        OrderLine result = orderLineService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveAllOrderLine")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<OrderLine>> saveAll(List<OrderLine> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllOrderLine")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<OrderLine>> getAll() throws Exception
    {
        List<OrderLine> result = orderLineService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
