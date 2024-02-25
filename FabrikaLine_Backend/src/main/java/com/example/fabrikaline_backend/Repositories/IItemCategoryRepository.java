package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
    List<ItemCategory> findByDescriptionContaining(String searchCriteria);
}
