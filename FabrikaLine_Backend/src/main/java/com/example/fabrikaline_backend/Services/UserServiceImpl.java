package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.*;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements IUserService, IAbstractService<User> {
    @Autowired
    IUserRepository iUserRepository ;
    IUserTypeRepository iUserTypeRepository;
    IUserGenderRepository iUserGenderRepository;
    IUserStatusRepository iUserStatusRepository;
    ICityRepository iCityRepository;
    ICountryRepository iCountryRepository;

    @Override
   // just for tests perposes nothing else
    public User saveAndAssign(Long usertype_id, Long usergender_id, Long userstatus_id, Long city_id, Long country_id, User user) {
        UserType userType = iUserTypeRepository.findById(usertype_id).orElseThrow(() -> new IllegalArgumentException("Invalid UserType Id"));
        UserGender userGender = iUserGenderRepository.findById(usergender_id).orElseThrow(() -> new IllegalArgumentException("Invalid UserGender Id"));
        UserStatus userStatus = iUserStatusRepository.findById(userstatus_id).orElseThrow(() -> new IllegalArgumentException("Invalid UserStatus Id"));
        City city = iCityRepository.findById(city_id).orElseThrow(() -> new IllegalArgumentException("Invalid City Id"));
        Country country = iCountryRepository.findById(country_id).orElseThrow(() -> new IllegalArgumentException("Invalid Country Id"));
        user.setUserType(userType);
        user.setUserGender(userGender);
        user.setUserStatus(userStatus);
        user.setCity(city);
        user.setCountry(country);
        return iUserRepository.save(user);
    }



    @Override
    public User save(User entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> saveAll(List<User> entities) throws Exception {
        return null;
    }

    @Override
    public List<User> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(User entity) throws ValidationException {

    }

    @Override
    public User getById(Long id) {
        return null;
    }
}
