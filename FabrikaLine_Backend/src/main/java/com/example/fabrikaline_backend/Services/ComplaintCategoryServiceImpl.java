package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IComplaintCategoryRepository;
import com.example.fabrikaline_backend.Repositories.IItemCategoryRepository;
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
public class ComplaintCategoryServiceImpl implements IComplaintCategoryService, IAbstractService<ComplaintCategory> {
    @Autowired
    IComplaintCategoryRepository iComplaintCategoryRepository;


    @Override
    public ComplaintCategory save(ComplaintCategory entity) throws Exception {
        return iComplaintCategoryRepository.save(entity);
    }

    @Override
    public void delete(Long id) { iComplaintCategoryRepository.deleteById(id);

    }

    @Override
    public List<ComplaintCategory> getAll() {return iComplaintCategoryRepository.findAll() ;}

    @Override
    public List<ComplaintCategory> saveAll(List<ComplaintCategory> entities) throws Exception {
        return null;
    }

    @Override
    public List<ComplaintCategory> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(ComplaintCategory entity) throws ValidationException {

    }

    @Override
    public ComplaintCategory getById(Long id) {
        return iComplaintCategoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }
}
