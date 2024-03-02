package com.example.fabrikaline_backend.Controllers;

import com.example.fabrikaline_backend.ABC.IAbstractController;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Entities.User;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Services.AttachmentCategoryServiceImpl;
import com.example.fabrikaline_backend.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/User")
@RestController
@CrossOrigin("*")


public class UserRestController implements IAbstractController<User> {

    //region Construct

    @Autowired
    UserServiceImpl userService;


    @Override
    public ResponseEntity<User> load(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

     @PostMapping("/save/{country_id}/{city_id}/{userstatus_id}/{usergender_id}/{usertype_id}")
    public ResponseEntity<User> addAndAssignUser(@RequestBody User user,@PathVariable Long country_id, @PathVariable Long city_id,@PathVariable Long userstatus_id,@PathVariable Long usergender_id,@PathVariable Long usertype_id) {
        User newUser = userService.saveAndAssign(usertype_id,usergender_id,userstatus_id,city_id,country_id,user) ;
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<User> save(User entity) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> saveAll(List<User> entities) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getAll() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> search(SearchCriteria criteria) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> getAll(Long page, Long size) throws Exception {
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
