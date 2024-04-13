package com.example.fabrikaline_backend.Controllers;
import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.Claim;
import com.example.fabrikaline_backend.Services.ClaimServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Claim")
@RestController
@CrossOrigin("*")


public class ClaimRestController implements IAbstractController<Claim> {
    @Autowired
    ClaimServiceImpl claimService;

    @Operation(operationId = "AdvancedSearchClaim")
    @GetMapping("/advancedSearch")
    public ResponseEntity<List<Claim>> advancedSearch(@RequestParam(value = "currentPos",required = false) Long currentPos, @RequestParam(value = "step",required = false) Long step, @RequestParam(value = "searchCriteria",required = false) String searchCriteria)
    {
        try {
            List<Claim> result = claimService.advancedSearch(currentPos, step, searchCriteria);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(operationId = "LoadClaim")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<Claim> load(@PathVariable Long id)
    {
        Claim result = claimService.getById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "DeleteClaim")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id)
    {
        claimService.delete(id);
    }

    @Override
    public ResponseEntity<Claim> save(@RequestBody Claim entity) throws Exception
    {
        Claim result = claimService.save(entity);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(operationId = "SaveClaim")
    @PostMapping("/save/{order_id}/{user_id}/{complainttype_id}/{complaintcategory_id}")
    public ResponseEntity<Claim> addAndAssignClaim(@RequestBody Claim claim, @PathVariable Long order_id, @PathVariable Long user_id, @PathVariable Long complainttype_id, @PathVariable Long complaintcategory_id) {
        Claim result = claimService.saveAndAssign(complaintcategory_id,complainttype_id,user_id,order_id,claim) ;
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Operation(operationId = "SaveAllClaim")
    @PostMapping("/SaveAll")
    @Override
    public ResponseEntity<List<Claim>> saveAll(List<Claim> entities) throws Exception
    {
        return null;
    }

    @Override
    @Operation(operationId = "GetAllClaim")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<Claim>> getAll() throws Exception
    {
        List<Claim> result = claimService.getAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
