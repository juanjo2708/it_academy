package com.academy.it.mongoConnection.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("expense")
public class Expense<ExpenseCategory> {
    @Id
    @Field(name="id")
    private String id;
    @Field(name="name")
    @Indexed(unique = true)
    private String expenseName;
    @Field(name="categoria")
    private ExpenseCat expenseCat;
    @Field(name="amount")
    private BigDecimal expenseAmount;

    public Expense(String id, String expenseName, ExpenseCat expenseCat, BigDecimal expenseAmount) {
        this.id = id;
        this.expenseName = expenseName;
        this.expenseCat = expenseCat;
        this.expenseAmount = expenseAmount;
    }

    public Expense(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseCat getExpenseCat() {
        return expenseCat;
    }

    public void setExpenseCat(ExpenseCat expenseCat) {
        this.expenseCat = expenseCat;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", expenseName='" + expenseName + '\'' +
                ", expenseCat=" + expenseCat +
                ", expenseAmount=" + expenseAmount +
                '}';
    }
}
