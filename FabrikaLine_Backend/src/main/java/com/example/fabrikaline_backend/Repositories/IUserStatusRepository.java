package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserStatusRepository extends JpaRepository<UserStatus,Long> {
}
