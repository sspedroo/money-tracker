package io.moneytracker.domain.subcategory.model;

import io.moneytracker.domain.category.model.Category;
import io.moneytracker.domain.transaction.model.Transaction;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "tb_subcategory")
@Table(name = "tb_subcategory")
@Getter
@Setter
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subcategory extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_category_id", nullable = false)
    private Category parentCategory;
    @OneToMany(mappedBy = "subcategory")
    private Set<Transaction> transactions = new HashSet<>();
}
