package com.example.fabrikaline_backend.Repositories;
import com.example.fabrikaline_backend.Entities.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
}
