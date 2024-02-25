package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IItemCategoryRepository;
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
    public ItemCategory getById(Long id) {
        return iItemCategoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<ItemCategory> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<ItemCategory> itemCategoryList;

        if (searchCriteria != null )
        {
            itemCategoryList = iItemCategoryRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            itemCategoryList = iItemCategoryRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), itemCategoryList.size());
            if (fromIndex < itemCategoryList.size() && fromIndex < toIndex) {
                return itemCategoryList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return itemCategoryList;
    }
}
