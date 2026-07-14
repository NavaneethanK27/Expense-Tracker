package com.example.Expense.Tracker.service;
import com.example.Expense.Tracker.Entity.Expense;
import com.example.Expense.Tracker.dto.request.ExpenseRequest;
import com.example.Expense.Tracker.dto.response.ExpenseResponse;

import java.util.List;

public interface ExpenseService {

    ExpenseResponse saveExpense(ExpenseRequest request);

    List<ExpenseResponse>getAllExpense();

    ExpenseResponse getExpenseById(Long id);

    ExpenseResponse updateExpense(Long id, ExpenseRequest request);

    void deleteExpense(Long id);

}
