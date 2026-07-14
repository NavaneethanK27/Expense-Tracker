package com.example.Expense.Tracker.service;
import java.util.*;
import com.example.Expense.Tracker.Entity.Expense;
import com.example.Expense.Tracker.dto.request.ExpenseRequest;
import com.example.Expense.Tracker.dto.response.ExpenseResponse;
import com.example.Expense.Tracker.exception.ExpenseNotFoundException;
import com.example.Expense.Tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponse saveExpense(ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setDate(request.getDate());

        Expense savedExpense = expenseRepository.save(expense);

        return mapToResponse(savedExpense);
    }

    @Override
    public List<ExpenseResponse> getAllExpense(){
        List<Expense>expenses = expenseRepository.findAll();
        List<ExpenseResponse>responseList = new ArrayList<>();

        for(Expense expense:expenses){
            responseList.add(mapToResponse(expense));
        }

        return  responseList;
    }

    @Override
    public ExpenseResponse getExpenseById(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id: " + id));


        return  mapToResponse(expense);
    }


    @Override
    public ExpenseResponse updateExpense(Long id,ExpenseRequest request){
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found with id: " + id));

        existingExpense.setTitle(request.getTitle());
        existingExpense.setAmount(request.getAmount());
        existingExpense.setCategory(request.getCategory());
        existingExpense.setDescription(request.getDescription());
        existingExpense.setDate(request.getDate());

        Expense updatedExpense =  expenseRepository.save(existingExpense);

        return mapToResponse(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    private ExpenseResponse mapToResponse(Expense expense){
        ExpenseResponse response = new ExpenseResponse();

        response.setId(expense.getId());
        response.setTitle(expense.getTitle());
        response.setAmount(expense.getAmount());
        response.setCategory(expense.getCategory());
        response.setDescription(expense.getDescription());
        response.setDate(expense.getDate());

        return response;

    }
}
