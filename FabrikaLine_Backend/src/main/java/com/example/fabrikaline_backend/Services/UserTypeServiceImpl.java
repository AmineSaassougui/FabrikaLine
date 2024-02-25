package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.UserType;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IUserTypeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.Collections;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class UserTypeServiceImpl implements IUserTypeService, IAbstractService<UserType> {
    @Autowired
    IUserTypeRepository userTypeRepository;


    @Override
    public UserType save(UserType entity) throws Exception {
        return userTypeRepository.save(entity);
    }

    @Override
    public void delete(Long id) { userTypeRepository.deleteById(id);

    }

    @Override
    public List<UserType> getAll() {return userTypeRepository.findAll() ;}

    @Override
    public List<UserType> saveAll(List<UserType> entities) throws Exception {
        return null;
    }

    @Override
    public List<UserType> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(UserType entity) throws ValidationException {

    }

    @Override
    public UserType getById(Long id) {
        return userTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<UserType> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<UserType> typeList;

        if (searchCriteria != null )
        {
            typeList = userTypeRepository.findByDescriptionContaining(searchCriteria);
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            typeList = userTypeRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), typeList.size());
            if (fromIndex < typeList.size() && fromIndex < toIndex) {
                return typeList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return typeList;
    }

}
