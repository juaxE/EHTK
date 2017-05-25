/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juho
 */
public class Budgeter {

    private Map<String, Double> income;
    private Map<String, Double> expenses;

    public Budgeter() {
        income = new HashMap<>();
        expenses = new HashMap<>();
    }

    public double checkBalance() {
        double a = 0;
        double b = 0;

        for (double i : income.values()) {
            a += i;
        }

        for (double i : expenses.values()) {
            b += i;
        }

        return a - b;

    }

    public void addExpense(String name, double value) {
        expenses.put(name, value);

    }

    public void addIncome(String name, double value) {
        income.put(name, value);
    }

    public Map<String, Double> getIncome() {
        return income;
    }

    public void setIncome(Map<String, Double> income) {
        this.income = income;
    }

    public Map<String, Double> getExpenses() {
        return expenses;
    }

    public void setExpenses(Map<String, Double> expenses) {
        this.expenses = expenses;
    }

}


//monthly income and expenses checker. could expand
