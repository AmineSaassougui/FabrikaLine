package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.User;
import com.example.fabrikaline_backend.Entities.UserGender;

import java.util.List;

public interface IUserService {
    // just for tests perposes nothing else


    // just for tests perposes nothing else
    User saveAndAssign(Long usertype_id, Long usergender_id, Long userstatus_id, Long city_id, Long country_id, User user);
}
