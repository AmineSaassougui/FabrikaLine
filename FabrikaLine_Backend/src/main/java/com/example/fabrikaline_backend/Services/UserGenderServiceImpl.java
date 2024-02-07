package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.UserGender;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IUserGenderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class UserGenderServiceImpl implements IUserGenderService, IAbstractService<UserGender> {
    @Autowired
    IUserGenderRepository iUserGenderRepository;


    @Override
    public UserGender save(UserGender entity) throws Exception {
        return iUserGenderRepository.save(entity);
    }

    @Override
    public void delete(Long id) { iUserGenderRepository.deleteById(id);

    }

    @Override
    public List<UserGender> getAll() {return iUserGenderRepository.findAll() ;}

    @Override
    public List<UserGender> saveAll(List<UserGender> entities) throws Exception {
        return null;
    }

    @Override
    public List<UserGender> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(UserGender entity) throws ValidationException {

    }

    @Override
    public UserGender getById(int id) {
        return null;
    }
}
