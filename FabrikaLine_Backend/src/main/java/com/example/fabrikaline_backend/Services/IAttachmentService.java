package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.Attachment;

public interface IAttachmentService {
    Attachment saveAndAssign(Long attachmentCategoryId, Attachment attachment);
}
