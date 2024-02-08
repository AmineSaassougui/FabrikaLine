package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserTypeRepository extends JpaRepository<UserType,Long> {
}
