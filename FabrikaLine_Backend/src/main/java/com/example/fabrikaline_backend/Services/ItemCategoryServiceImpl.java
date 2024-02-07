package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Country;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IItemCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class ItemCategoryServiceImpl implements IItemCategoryService, IAbstractService<ItemCategory> {
    @Autowired
    IItemCategoryRepository iItemCategoryRepository;


    @Override
    public ItemCategory save(ItemCategory entity) throws Exception {
        return iItemCategoryRepository.save(entity);
    }

    @Override
    public void delete(Long id) { iItemCategoryRepository.deleteById(id);

    }

    @Override
    public List<ItemCategory> getAll() {return iItemCategoryRepository.findAll() ;}

    @Override
    public List<ItemCategory> saveAll(List<ItemCategory> entities) throws Exception {
        return null;
    }

    @Override
    public List<ItemCategory> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(ItemCategory entity) throws ValidationException {

    }

    @Override
    public ItemCategory getById(int id) {
        return null;
    }
}
