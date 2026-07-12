package com.example.Expense.Tracker.repsoitory;
import com.example.Expense.Tracker.Entity.Expense;
import com.example.Expense.Tracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}