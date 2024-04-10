package com.example.fabrikaline_backend.Services;
import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.UserGender;
import com.example.fabrikaline_backend.Repositories.IUserGenderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserGenderServiceImpl implements IUserGenderService, IAbstractService<UserGender> {
    @Autowired
    IUserGenderRepository iUserGenderRepository;


    @Override
    public UserGender save(UserGender entity) throws Exception {
        return iUserGenderRepository.save(entity);
    }

    @Override
    public void delete(Long id) { iUserGenderRepository.deleteById(id);

    }

    @Override
    public List<UserGender> getAll() {return iUserGenderRepository.findAll() ;}

    public List<UserGender> advancedSearch(long offset, long size) {
        // Create a PageRequest with pagination parameters
        Pageable pageable = PageRequest.of((int) offset, (int) size);

        // Fetch items from the database using pagination
        Page<UserGender> itemPage = iUserGenderRepository.findAll(pageable);

        // Extract and return the list of items from the Page
        return itemPage.getContent();
    }
    @Override
    public List<UserGender> saveAll(List<UserGender> entities) throws Exception {
        return null;
    }

    @Override
    public UserGender getById(Long id) {
        return iUserGenderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item  not found  in our repsitory"));
    }

    @Override
    public List<UserGender> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<UserGender> userGenderList;

        if (searchCriteria != null )
        {
            userGenderList = iUserGenderRepository.findByDescriptionContaining(searchCriteria);
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            userGenderList = iUserGenderRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), userGenderList.size());
            if (fromIndex < userGenderList.size() && fromIndex < toIndex) {
                return userGenderList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return userGenderList;
    }
}
