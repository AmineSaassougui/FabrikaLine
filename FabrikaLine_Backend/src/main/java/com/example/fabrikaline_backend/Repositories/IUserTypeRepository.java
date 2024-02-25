package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserTypeRepository extends JpaRepository<UserType,Long> {
    List<UserType> findByDescriptionContaining(String searchCriteria);
}
