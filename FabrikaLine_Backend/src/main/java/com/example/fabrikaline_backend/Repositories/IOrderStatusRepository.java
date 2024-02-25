package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderStatusRepository extends JpaRepository<OrderStatus,Long> {
    List<OrderStatus> findByDescriptionContaining(String searchCriteria);
}
