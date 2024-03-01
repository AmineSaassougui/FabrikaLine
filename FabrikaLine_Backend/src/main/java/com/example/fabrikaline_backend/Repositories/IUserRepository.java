package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IUserRepository extends JpaRepository<User,Long> {
}
