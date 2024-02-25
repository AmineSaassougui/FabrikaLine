package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IOrderStatusRepository;
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
public class OrderStatusServiceImpl implements IOrderStatusService, IAbstractService<OrderStatus> {
    @Autowired
    IOrderStatusRepository orderStatusRepository;


    @Override
    public OrderStatus save(OrderStatus entity) throws Exception {
        return orderStatusRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        orderStatusRepository.deleteById(id);
    }

    @Override
    public List<OrderStatus> getAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public List<OrderStatus> saveAll(List<OrderStatus> entities) throws Exception {
        return null; //TODO
    }

    @Override
    public List<OrderStatus> search(SearchCriteria criteria) {
        return null; //TODO
    }

    @Override
    public long count() {
        return 0;  //TODO
    }

    @Override
    public void validate(OrderStatus entity) throws ValidationException {
        //TODO
    }

    @Override
    public OrderStatus getById(Long id) {
        return orderStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }
    @Override
    public List<OrderStatus> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<OrderStatus> orderStatusList;

        if (searchCriteria != null )
        {
            orderStatusList = orderStatusRepository.findByDescriptionContaining(searchCriteria);
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            orderStatusList = orderStatusRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), orderStatusList.size());
            if (fromIndex < orderStatusList.size() && fromIndex < toIndex) {
                return orderStatusList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return orderStatusList;
    }
}
