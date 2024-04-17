package io.moneytracker.domain.subcategory.repository;

import io.moneytracker.domain.subcategory.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
}
