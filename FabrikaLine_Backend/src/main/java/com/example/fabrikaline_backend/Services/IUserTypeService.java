package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.UserType;

import java.util.List;

public interface IUserTypeService {
    List<UserType> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
