package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.ComplaintCategory;

import java.util.List;

public interface IComplaintCategoryService {
    List<ComplaintCategory> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
