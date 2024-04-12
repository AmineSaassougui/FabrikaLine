package com.example.fabrikaline_backend.Services;


import com.example.fabrikaline_backend.Entities.ComplaintType;

import java.util.List;

public interface IComplaintTypeService {
    ComplaintType saveAndAssign(Long complaintcategory_id, ComplaintType complaintType);

    List<ComplaintType> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
