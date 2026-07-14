package com.example.Expense.Tracker.Controller;

import com.example.Expense.Tracker.dto.request.ExpenseRequest;
import com.example.Expense.Tracker.dto.response.ExpenseResponse;
import com.example.Expense.Tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Create Expense
    @PostMapping("/save")
    public ResponseEntity<ExpenseResponse> saveExpense(@Valid @RequestBody ExpenseRequest request) {

        ExpenseResponse response = expenseService.saveExpense(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get All Expenses
    @GetMapping("/get")
    public ResponseEntity<List<ExpenseResponse>> getAllExpense() {

        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    // Get Expense By Id
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable Long id) {

        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    // Update Expense
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseResponse> updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseRequest request) {

        return ResponseEntity.ok(expenseService.updateExpense(id, request));
    }

    // Delete Expense
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {

        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}