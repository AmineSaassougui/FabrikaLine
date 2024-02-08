package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachmentCategoryRepository extends JpaRepository<AttachmentCategory,Long> {
}
