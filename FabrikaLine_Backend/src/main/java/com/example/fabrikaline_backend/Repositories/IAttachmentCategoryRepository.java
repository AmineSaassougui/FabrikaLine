package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAttachmentCategoryRepository extends JpaRepository<AttachmentCategory,Long> {
    List<AttachmentCategory> findByDescriptionContaining(String searchCriteria);
}
