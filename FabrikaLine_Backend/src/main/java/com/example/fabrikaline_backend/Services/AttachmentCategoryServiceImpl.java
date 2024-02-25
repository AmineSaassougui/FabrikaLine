package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IAttachmentCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AttachmentCategoryServiceImpl implements IAttachmentCategoryService, IAbstractService<AttachmentCategory> {
    @Autowired
    IAttachmentCategoryRepository attachmentCategoryRepository;


    @Override
    public AttachmentCategory save(AttachmentCategory entity) throws Exception {
        return attachmentCategoryRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        attachmentCategoryRepository.deleteById(id);
    }

    @Override
    public List<AttachmentCategory> getAll() {
        return attachmentCategoryRepository.findAll();
    }

    @Override
    public List<AttachmentCategory> saveAll(List<AttachmentCategory> entities) throws Exception {
        return null; //TODO
    }

    @Override
    public List<AttachmentCategory> search(SearchCriteria criteria) {
        return null; //TODO
    }

    @Override
    public long count() {
        return 0;  //TODO
    }

    @Override
    public void validate(AttachmentCategory entity) throws ValidationException {
        //TODO
    }

    @Override
    public AttachmentCategory getById(Long id) {
        return attachmentCategoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<AttachmentCategory> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<AttachmentCategory> categoryList;

        if (searchCriteria != null )
        {
            categoryList = attachmentCategoryRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            categoryList = attachmentCategoryRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), categoryList.size());
            if (fromIndex < categoryList.size() && fromIndex < toIndex) {
                return categoryList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return categoryList;
    }


}
