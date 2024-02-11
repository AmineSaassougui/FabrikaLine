package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Item;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IItemCategoryRepository;
import com.example.fabrikaline_backend.Repositories.IItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class ItemServiceImpl implements IItemService, IAbstractService<Item> {
    @Autowired
    IItemCategoryRepository iItemCategoryRepository;
    @Autowired
    IItemRepository iItemRepository;


    @Override
    public Item saveAndAssign(Long categoryId, Item item){
        ItemCategory category = iItemCategoryRepository.findById(categoryId) .
                orElseThrow(() -> new IllegalArgumentException("Invalid Category Id"));
        item.setItemCategory(category);
        return iItemRepository.save(item);
    }


    @Override
    public Item save(Item entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        iItemRepository.deleteById(id);
    }

    @Override
    public List<Item> getAll() {
        return iItemRepository.findAll();
    }

    @Override
    public List<Item> saveAll(List<Item> entities) throws Exception {
        return null;
    }

    @Override
    public List<Item> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(Item entity) throws ValidationException {

    }

    @Override
    public Item getById(int id) {
        return null;
    }
}
