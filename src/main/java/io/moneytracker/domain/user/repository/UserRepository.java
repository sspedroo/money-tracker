package io.moneytracker.domain.user.repository;

import io.moneytracker.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
