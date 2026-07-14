package com.example.Expense.Tracker.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Expense.Tracker.Entity.User;
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User>findByEmail(String email);

    boolean existsByEmail(String email);

}
