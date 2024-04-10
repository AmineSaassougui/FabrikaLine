package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Attachment;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Repositories.IAttachmentCategoryRepository;
import com.example.fabrikaline_backend.Repositories.IAttachmentRepository;
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
public class AttachmentServiceImpl implements IAttachmentService, IAbstractService<Attachment> {
    @Autowired
    IAttachmentRepository iAttachmentRepository;
    @Autowired
    IAttachmentCategoryRepository attachmentCategoryRepository;

    @Override
    public Attachment saveAndAssign(Long attachmentCategoryId, Attachment attachment){
        AttachmentCategory attachmentCategory = attachmentCategoryRepository.findById(attachmentCategoryId) .orElseThrow(() -> new IllegalArgumentException("Invalid attachmentCategory Id"));
        attachment.setAttachmentCategory(attachmentCategory);
        var attachedFile = attachment.getAttachedFile();
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
            if (currentPos < 0 || step <= 0)
            {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            long startingPos = currentPos * step;
            attachments = iAttachmentRepository.findAll(); // ?????? TODO
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), attachments.size());
            if (fromIndex < attachments.size() && fromIndex < toIndex)
            {
                return attachments.subList(fromIndex, toIndex);
            } else
                    {
                        return Collections.emptyList();
                    }
        }
        return attachments;
    }

    public List<Attachment> getAttachmenstByParentId(Long parentId) throws Exception
    {
        List<Attachment> attachments = null;

        if (parentId != null )
        {
            attachments = iAttachmentRepository.findAttachmentsByParentId(parentId) ;
        }
        return attachments;
    }

}