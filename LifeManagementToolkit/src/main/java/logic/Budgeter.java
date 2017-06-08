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
 * Class keeps track of income and expenses.
 */
public class Budgeter {

    private Map<String, Double> income;
    private Map<String, Double> expenses;

    /**
     * Constructor that sets the Map attributes for income and expenses.
     */
    public Budgeter() {
        income = new HashMap<>();
        expenses = new HashMap<>();
    }

    /**
     * Calculates the balance.
     *
     * @return The division of income and expenses.
     */
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

    /**
     * This method adds expenses to the Map.
     *
     * @param name name of the expense
     * @param value expense amount
     */
    public void addExpense(String name, double value) {
        if (expenses.keySet().contains(name)) {
            expenses.put(name, value + expenses.get(name));
        } else {
            expenses.put(name, value);
        }

    }

    /**
     * This method adds income to the Map.
     *
     * @param name name of the income
     * @param value income amount
     */
    public void addIncome(String name, double value) {
        if (income.keySet().contains(name)) {
            income.put(name, value + income.get(name));
        } else {
            income.put(name, value);
        }

    }

    /**
     * Method returns the Map of incomes given to object.
     *
     * @return income map
     */
    public Map<String, Double> getIncome() {
        return income;
    }

    /**
     * Method returns the Map of expenses given to object.
     *
     * @return expense map
     */
    public Map<String, Double> getExpenses() {
        return expenses;
    }

}


//monthly income and expenses checker. could expand
