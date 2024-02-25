package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.Claim;
import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IComplaintCategoryRepository extends JpaRepository<ComplaintCategory,Long> {
    List<ComplaintCategory> findByDescriptionContaining(String searchCriteria);
}
