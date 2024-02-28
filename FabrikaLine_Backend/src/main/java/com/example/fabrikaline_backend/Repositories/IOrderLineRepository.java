package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrderLineRepository extends JpaRepository<OrderLine,Long> {

}
