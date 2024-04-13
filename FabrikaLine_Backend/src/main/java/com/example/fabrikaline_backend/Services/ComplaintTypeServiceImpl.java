package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.*;
import com.example.fabrikaline_backend.Repositories.IComplaintCategoryRepository;
import com.example.fabrikaline_backend.Repositories.IComplaintTypeRepository;
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
public class ComplaintTypeServiceImpl implements IComplaintTypeService, IAbstractService<ComplaintType> {
    @Autowired
    IComplaintTypeRepository iComplaintTypeRepository;
    @Autowired
    IComplaintCategoryRepository iComplaintCategoryRepository;



    @Override
    public ComplaintType save(ComplaintType entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        iComplaintTypeRepository.deleteById(id);

    }

    @Override
    public List<ComplaintType> getAll() {
        return iComplaintTypeRepository.findAll();
    }

    @Override
    public List<ComplaintType> saveAll(List<ComplaintType> entities) throws Exception {
        return null;
    }


    @Override
    public ComplaintType getById(Long id) {
        return iComplaintTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ComplaintType with id :" + id + " not found"));
    }

    @Override
    public ComplaintType saveAndAssign(Long complaintcategory_id, ComplaintType complaintType) {
        ComplaintCategory complaintCategory = iComplaintCategoryRepository.findById(complaintcategory_id).orElseThrow(() -> new IllegalArgumentException("Invalid ComplaintCategory Id"));
        complaintType.setComplaintCategory(complaintCategory);
        return iComplaintTypeRepository.save(complaintType);
    }


    @Override
    public List<ComplaintType> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<ComplaintType> complaintTypes;

        if (searchCriteria != null )
        {
            complaintTypes = iComplaintTypeRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            complaintTypes = iComplaintTypeRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), complaintTypes.size());
            if (fromIndex < complaintTypes.size() && fromIndex < toIndex) {
                return complaintTypes.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return complaintTypes;
    }
}
