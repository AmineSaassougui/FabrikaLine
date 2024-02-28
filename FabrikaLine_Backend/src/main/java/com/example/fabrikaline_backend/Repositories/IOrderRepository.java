package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {

}
