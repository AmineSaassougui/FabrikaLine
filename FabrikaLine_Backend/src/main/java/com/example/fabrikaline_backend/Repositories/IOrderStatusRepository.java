package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderStatusRepository extends JpaRepository<OrderStatus,Long> {
}
