package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Attachment;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IAttachmentCategoryRepository;
import com.example.fabrikaline_backend.Repositories.IAttachmentRepository;
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
public class AttachmentServiceImpl implements IAttachmentService, IAbstractService<Attachment> {
    @Autowired
    IAttachmentRepository iAttachmentRepository;
    @Autowired
    IAttachmentCategoryRepository attachmentCategoryRepository;


    @Override
    public Attachment saveAndAssign(Long attachmentCategoryId, Attachment attachment){
        AttachmentCategory attachmentCategory = attachmentCategoryRepository.findById(attachmentCategoryId) .orElseThrow(() -> new IllegalArgumentException("Invalid attachmentCategory Id"));
        attachment.setAttachmentCategory(attachmentCategory);
        return iAttachmentRepository.save(attachment);
    }


    @Override
    public Attachment save(Attachment entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) { iAttachmentRepository.deleteById(id);}

    @Override
    public List<Attachment> getAll() {
        return iAttachmentRepository.findAll();
    }

    @Override
    public List<Attachment> saveAll(List<Attachment> entities) throws Exception {
        return null;
    }

    @Override
    public List<Attachment> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(Attachment entity) throws ValidationException {

    }

    @Override
    public Attachment getById(Long id) {
        return iAttachmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<Attachment> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<Attachment> attachments;

        if (searchCriteria != null )
        {
            attachments = iAttachmentRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            attachments = iAttachmentRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), attachments.size());
            if (fromIndex < attachments.size() && fromIndex < toIndex) {
                return attachments.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return attachments;
    }


}
