package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.DTO.ItemWithAttachmentsDTO;
import com.example.fabrikaline_backend.Entities.Item;

import java.util.List;

public interface IItemService {
    Item saveAndAssign(Long categoryId, Item item);

    List<Item> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;

    List<ItemWithAttachmentsDTO> getAllItemsWithAttachments(String searchCriteria) throws Exception;


}
