package io.moneytracker.domain.category.repository;

import io.moneytracker.domain.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
