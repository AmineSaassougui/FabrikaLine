package com.example.fabrikaline_backend.Services;
import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.*;
import com.example.fabrikaline_backend.Repositories.IItemRepository;
import com.example.fabrikaline_backend.Repositories.IOrderLineRepository;
import com.example.fabrikaline_backend.Repositories.IOrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class OrderLineServiceImpl implements IOrderLineService, IAbstractService<OrderLine> {
    @Autowired
    IOrderLineRepository iOrderLineRepository;
    @Autowired
    IItemRepository iItemRepository;
    @Autowired
    IOrderRepository iOrderRepository;


    public List<OrderLine> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<OrderLine> resList;

        if (searchCriteria != null )
        {
            resList = iOrderLineRepository.findByQuantityContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            resList = iOrderLineRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), resList.size());
            if (fromIndex < resList.size() && fromIndex < toIndex) {
                return resList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return resList;
    }
    @Override
    public OrderLine save(OrderLine entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        iOrderLineRepository.deleteById(id);
    }

    @Override
    public List<OrderLine> getAll() {
        return iOrderLineRepository.findAll();
    }

    @Override
    public List<OrderLine> saveAll(List<OrderLine> entities) throws Exception {
        return null;
    }


    @Override
    public OrderLine getById(Long id) {
        return iOrderLineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("OrderLine with id :" + id + " not found"));
    }

    public OrderLine saveAndAssign(Long order_id, Long item_id, OrderLine orderLine) {
        Order order = iOrderRepository.findById(order_id).orElseThrow(() -> new IllegalArgumentException("Invalid Order Id"));
        Item item = iItemRepository.findById(item_id).orElseThrow(() -> new IllegalArgumentException("Invalid Item Id"));
        orderLine.setOrder(order);
        orderLine.setItem(item);
        orderLine.setTotalPrice(orderLine.getQuantity()*item.getPrice());
        return iOrderLineRepository.save(orderLine);
    }
}


