package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserStatusRepository extends JpaRepository<UserStatus,Long> {
    List<UserStatus> findByDescriptionContaining(String searchCriteria);
}
