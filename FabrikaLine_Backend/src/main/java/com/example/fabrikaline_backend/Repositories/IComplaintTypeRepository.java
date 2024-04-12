package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import com.example.fabrikaline_backend.Entities.ComplaintType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IComplaintTypeRepository extends JpaRepository<ComplaintType,Long> {
    List<ComplaintType> findByDescriptionContaining(String searchCriteria);
}
