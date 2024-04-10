package com.example.fabrikaline_backend.Services;
import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.*;
import com.example.fabrikaline_backend.Repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Collections;
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


    public List<User> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<User> resList;

        if (searchCriteria != null )
        {
            resList = iUserRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            resList = iUserRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), resList.size());
            if (fromIndex < resList.size() && fromIndex < toIndex) {
                return resList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return resList;
    }

    
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
        iUserRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return iUserRepository.findAll();
    }



    @Override
    public List<User> saveAll(List<User> entities) throws Exception {
        return null;
    }

    @Override
    public User getById(Long id) {
        return iUserRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id :" + id + " not found"));
    }
}


