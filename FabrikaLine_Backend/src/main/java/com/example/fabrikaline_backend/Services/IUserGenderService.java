package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.UserGender;

import java.util.List;

public interface IUserGenderService {
    List<UserGender> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
