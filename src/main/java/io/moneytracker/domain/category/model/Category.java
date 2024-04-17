package io.moneytracker.domain.category.model;

import io.moneytracker.domain.subcategory.model.Subcategory;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Entity(name = "tb_category")
@Table(name = "tb_category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @OneToMany(mappedBy = "parentCategory")
    @Setter(AccessLevel.NONE)
    @Column(nullable = false)
    @OrderBy("name DESC")
    private Set<Subcategory> subcategories = new HashSet<>();
}
