package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import com.example.fabrikaline_backend.Entities.ComplaintType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComplaintTypeRepository extends JpaRepository<ComplaintType,Long> {
}
