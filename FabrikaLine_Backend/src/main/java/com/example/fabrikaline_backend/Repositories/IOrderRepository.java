package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.AttachmentCategory;
import com.example.fabrikaline_backend.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByDescriptionContaining(String searchCriteria);

}
