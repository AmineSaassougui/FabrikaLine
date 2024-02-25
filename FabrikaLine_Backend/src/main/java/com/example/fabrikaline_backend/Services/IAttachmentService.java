package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.Attachment;

import java.util.List;

public interface IAttachmentService {
    Attachment saveAndAssign(Long attachmentCategoryId, Attachment attachment);

    List<Attachment> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
