package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Entities.UserStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IOrderStatusRepository;
import com.example.fabrikaline_backend.Repositories.IUserStatusRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
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
    public OrderStatus getById(int id) {
        return null; //TODO
    }
}
