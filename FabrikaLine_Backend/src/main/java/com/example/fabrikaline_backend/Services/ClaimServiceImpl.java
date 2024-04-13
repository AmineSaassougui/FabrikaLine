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
public class ClaimServiceImpl implements IClaimService, IAbstractService<Claim> {
    @Autowired
    IClaimRepository iClaimRepository;
    @Autowired
    IComplaintCategoryRepository iComplaintCategoryRepository;
    @Autowired
    IComplaintTypeRepository iComplaintTypeRepository;
    @Autowired
    IUserRepository iUserRepository ;
    @Autowired
    IOrderRepository iOrderRepository;



    @Override
    public Claim save(Claim entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        iClaimRepository.deleteById(id);

    }

    @Override
    public List<Claim> getAll() {
        return iClaimRepository.findAll();
    }

    @Override
    public List<Claim> saveAll(List<Claim> entities) throws Exception {
        return null;
    }


    @Override
    public Claim getById(Long id) {
        return iClaimRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Claim with id :" + id + " not found"));
    }

    @Override
    public Claim saveAndAssign(Long complaintcategory_id,Long complainttype_id,Long user_id,Long order_id, Claim claim) {
        ComplaintCategory complaintCategory = iComplaintCategoryRepository.findById(complaintcategory_id).orElseThrow(() -> new IllegalArgumentException("Invalid ComplaintCategory Id"));
        ComplaintType complaintType = iComplaintTypeRepository.findById(complainttype_id).orElseThrow(() -> new IllegalArgumentException("Invalid ComplaintType Id"));
        User user = iUserRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id"));
        Order order = iOrderRepository.findById(order_id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id"));
        claim.setComplaintCategory(complaintCategory);
        claim.setComplaintType(complaintType);
        claim.setUser(user);
        claim.setOrder(order);
        return iClaimRepository.save(claim);
    }


    @Override
    public List<Claim> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<Claim> claims;

        if (searchCriteria != null )
        {
            claims = iClaimRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            claims = iClaimRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), claims.size());
            if (fromIndex < claims.size() && fromIndex < toIndex) {
                return claims.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return claims;
    }
}
