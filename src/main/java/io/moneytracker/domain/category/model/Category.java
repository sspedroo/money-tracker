package io.moneytracker.domain.category.model;

import io.moneytracker.domain.subcategory.model.Subcategory;
import io.moneytracker.domain.transaction.model.Transaction;
import io.moneytracker.domain.user.model.User;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;
@Entity(name = "tb_category")
@Table(name = "tb_category")
@Getter
@Setter
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;
    @OneToMany(mappedBy = "parentCategory")
    @Setter(AccessLevel.NONE)
    @Column(nullable = false)
    @OrderBy("name DESC")
    private Set<Subcategory> subcategories = new HashSet<>();
    @OneToMany(mappedBy = "category")
    @Setter(AccessLevel.NONE)
    private Set<Transaction> transactions = new HashSet<>();
}
