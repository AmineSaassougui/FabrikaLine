package com.example.fabrikaline_backend.Services;
import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Order;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import com.example.fabrikaline_backend.Entities.User;
import com.example.fabrikaline_backend.Repositories.IOrderRepository;
import com.example.fabrikaline_backend.Repositories.IOrderStatusRepository;
import com.example.fabrikaline_backend.Repositories.IUserRepository;
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
public class OrderServiceImpl implements IOrderService, IAbstractService<Order> {
    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    IUserRepository iUserRepository ;
    @Autowired
    IOrderStatusRepository iOrderStatusRepository;

    public List<Order> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception
    {

        List<Order> orderList;

        if (searchCriteria != null )
        {
            orderList = iOrderRepository.findByDescriptionContaining(searchCriteria) ;
        }
        else
        {
            if (currentPos < 0 || step <= 0) {
                throw new IllegalArgumentException("Invalid currentPos or step value");
            }
            // Calculate the starting position based on the currentPos and step
            long startingPos = currentPos * step;

            // If searchCriteria is null or description is null, get all countries
            orderList = iOrderRepository.findAll(); // ?????? TODO

            // Apply pagination to the search results
            int fromIndex = currentPos.intValue();
            int toIndex = Math.min(fromIndex + step.intValue(), orderList.size());
            if (fromIndex < orderList.size() && fromIndex < toIndex) {
                return orderList.subList(fromIndex, toIndex);
            } else {
                return Collections.emptyList();
            }
        }
        return orderList;
    }
    @Override
    public Order save(Order entity) throws Exception {
        return iOrderRepository.save(entity);
    }

    @Override
    public void delete(Long id)
    {

        iOrderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public List<Order> saveAll(List<Order> entities) throws Exception {
        return null;
    }


    @Override
    public Order getById(Long id) {
        return iOrderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Order with id :" + id + " not found"));
    }


    public Order saveAndAssign(Long user_id, Long orderstatus_id, Order order) {
        User user = iUserRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id"));
        OrderStatus orderStatus = iOrderStatusRepository.findById(orderstatus_id).orElseThrow(() -> new IllegalArgumentException("Invalid OrderStatus Id"));
        // Set the order date to the current timestamp
        order.setOrderDate(new Date());
        order.setUser(user);
        order.setOrderStatus(orderStatus);
        return iOrderRepository.save(order);
    }




}
