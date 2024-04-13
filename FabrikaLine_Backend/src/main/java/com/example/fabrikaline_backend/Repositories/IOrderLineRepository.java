package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IOrderLineRepository extends JpaRepository<OrderLine,Long> {
    List<OrderLine> findByQuantityContaining(String searchCriteria);
    List<OrderLine> findByOrderId(Long orderId);
}
