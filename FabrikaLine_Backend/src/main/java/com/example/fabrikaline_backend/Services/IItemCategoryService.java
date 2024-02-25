package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.ItemCategory;

import java.util.List;

public interface IItemCategoryService {
    List<ItemCategory> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
