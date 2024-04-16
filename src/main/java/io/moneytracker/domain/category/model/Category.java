package io.moneytracker.domain.category.model;

import io.moneytracker.domain.subcategory.model.Subcategory;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @OneToMany(mappedBy = "category")
    @Setter(AccessLevel.NONE)
    @Column(nullable = false)
    @OrderBy("name DESC")
    private Set<Subcategory> subcategories = new HashSet<>();
}
