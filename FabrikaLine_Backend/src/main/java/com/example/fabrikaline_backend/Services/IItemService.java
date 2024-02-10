package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.Item;

public interface IItemService {
    Item saveAndAssign(Long categoryId, Item item);
}
