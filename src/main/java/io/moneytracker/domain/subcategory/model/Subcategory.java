package io.moneytracker.domain.subcategory.model;

import io.moneytracker.domain.category.model.Category;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subcategory extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_category_id", nullable = false)
    private Category parentCategory;
}
