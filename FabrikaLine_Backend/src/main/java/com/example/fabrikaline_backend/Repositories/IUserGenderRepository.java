package com.example.fabrikaline_backend.Repositories;


import com.example.fabrikaline_backend.Entities.City;
import com.example.fabrikaline_backend.Entities.UserGender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserGenderRepository extends JpaRepository<UserGender,Long> {
    List<UserGender> findByDescriptionContaining(String searchCriteria);
}
