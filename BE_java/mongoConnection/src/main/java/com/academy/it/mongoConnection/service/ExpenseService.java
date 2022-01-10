package com.academy.it.mongoConnection.service;

import com.academy.it.mongoConnection.model.Expense;
import com.academy.it.mongoConnection.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        Expense insert = expenseRepository.insert(expense);
    }

    public ResponseEntity updateExpense(Expense expense){
        /** Expense savedExpense = expenseRepository.findById(expense.getId().toString())
                .orElseThrow(()-> new RuntimeException(String.format("Cannot find a expense by id %s",expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCat(expense.getExpenseCat());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        **/
        expenseRepository.save(expense);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException(String.format("Cannot find a expense by name %s",name)));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
