package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.UserStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IUserStatusRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserStatusServiceImpl implements IUserStatusService, IAbstractService<UserStatus> {
    @Autowired
    IUserStatusRepository userStatusRepository;


    @Override
    public UserStatus save(UserStatus entity) throws Exception {
        return userStatusRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userStatusRepository.deleteById(id);
    }

    @Override
    public List<UserStatus> getAll() {
        return userStatusRepository.findAll();
    }

    @Override
    public List<UserStatus> saveAll(List<UserStatus> entities) throws Exception {
        return null; //TODO
    }

    @Override
    public List<UserStatus> search(SearchCriteria criteria) {
        return null; //TODO
    }

    @Override
    public long count() {
        return 0;  //TODO
    }

    @Override
    public void validate(UserStatus entity) throws ValidationException {
        //TODO
    }

    @Override
    public UserStatus getById(Long id) {
        return userStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }
}
