package com.example.Expense.Tracker.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.time.LocalDate;
@Data
public class ExpenseRequest {

    @NotBlank(message="Title is required")
    private String title;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @NotBlank(message="Category is required")
    private String category;

    private String description;

    @NotNull(message = "Date is Required")
    private LocalDate date;
}
