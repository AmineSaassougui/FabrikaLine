package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.UserStatus;

import java.util.List;

public interface IUserStatusService {
    List<UserStatus> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
