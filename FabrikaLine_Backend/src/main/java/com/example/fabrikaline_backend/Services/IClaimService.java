package com.example.fabrikaline_backend.Services;


import com.example.fabrikaline_backend.Entities.Claim;

import java.util.List;

public interface IClaimService {
    Claim saveAndAssign(Long complaintcategory_id, Long complainttype_id, Long user_id, Long order_id, Claim claim);

    List<Claim> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
