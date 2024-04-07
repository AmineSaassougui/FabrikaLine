package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByNameContainingOrDescriptionContaining(String searchCriteria, String searchCriteria2);
}
