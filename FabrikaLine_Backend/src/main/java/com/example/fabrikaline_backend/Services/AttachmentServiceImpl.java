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

import javax.validation.ValidationException;
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
        return null;
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
        return null;
    }
}
