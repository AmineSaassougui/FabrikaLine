package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item,Long> {
}
