package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.ComplaintCategory;
import com.example.fabrikaline_backend.Entities.Order;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IComplaintCategoryRepository;
import com.example.fabrikaline_backend.Repositories.IOrderRepository;
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
public class OrderServiceImpl implements IOrderService, IAbstractService<Order> {
    @Autowired
    IOrderRepository iOrderRepository;


    @Override
    public Order save(Order entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> saveAll(List<Order> entities) throws Exception {
        return null;
    }

    @Override
    public List<Order> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(Order entity) throws ValidationException {

    }

    @Override
    public Order getById(Long id) {
        return null;
    }
}
