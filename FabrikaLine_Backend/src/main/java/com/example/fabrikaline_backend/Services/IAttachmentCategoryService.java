package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.AttachmentCategory;

import java.util.List;

public interface IAttachmentCategoryService {
    List<AttachmentCategory> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
