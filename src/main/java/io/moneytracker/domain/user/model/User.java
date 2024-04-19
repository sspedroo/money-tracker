package io.moneytracker.domain.user.model;

import io.moneytracker.domain.category.model.Category;
import io.moneytracker.domain.paymentMethods.model.PaymentMethod;
import io.moneytracker.domain.transaction.model.Transaction;
import io.moneytracker.infra.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "tb_user_db")
@Table(name = "tb_user_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    private String name;
    private String email;
    private String password;
    private Integer isActive = 1;
    private String profileImage;
    @OneToMany(mappedBy = "user")
    private Set<Transaction> transactions = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<Category> categories = new HashSet<>();
    @OneToMany
    private Set<PaymentMethod> paymentMethods = new HashSet<>();
}
