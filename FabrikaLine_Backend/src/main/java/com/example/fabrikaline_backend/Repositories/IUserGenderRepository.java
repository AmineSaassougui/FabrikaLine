package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Entities.UserGender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserGenderRepository extends JpaRepository<UserGender,Long> {
}
