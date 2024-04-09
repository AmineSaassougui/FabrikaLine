package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Item;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.OrderStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/OrderStatus")
@RestController
@CrossOrigin("*")



public class OrderStatusRestController implements IAbstractController<OrderStatus> {

    //region Construct

    @Autowired
    OrderStatusServiceImpl orderStatusService;

    @GetMapping("/advancedSearch")
    public ResponseEntity<List<OrderStatus>> advancedSearch(
            @RequestParam(value = "currentPos",required = false) Long currentPos,
            @RequestParam(value = "step",required = false) Long step,
            //@RequestBody(required = true) SearchCriteria searchCriteria
            @RequestParam(value = "searchCriteria",required = false) String searchCriteria
    ) {
        try {
            List<OrderStatus> searchResults = orderStatusService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<OrderStatus> load(@PathVariable Long id) {
        OrderStatus status= orderStatusService.getById(id);
        return new ResponseEntity<>(status,HttpStatus.OK);

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
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<OrderStatus>> getAll() throws Exception {
        List<OrderStatus> orderStatusList = orderStatusService.getAll();
        return new ResponseEntity<>(orderStatusList,HttpStatus.OK);
    }

}
