/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Juho
 */
public class BudgeterTest {

    Budgeter budgeter;

    @Before
    public void initialize() {
        budgeter = new Budgeter();
    }

    @Test
    public void addsExpenses() {
        budgeter.addExpense("a", 100.0);

        assertTrue(budgeter.getExpenses().containsKey("a"));
        assertTrue(budgeter.getExpenses().containsValue(100.0));
    }

    @Test
    public void addsToExistingExpense() {
        budgeter.addExpense("k", 0.01);
        budgeter.addExpense("k", 5.04);

        assertTrue(budgeter.getExpenses().containsValue(5.05));
    }

    @Test
    public void addsIncome() {
        budgeter.addIncome("k", 0.01);

        assertTrue(budgeter.getIncome().containsKey("k"));
        assertTrue(budgeter.getIncome().containsValue(0.01));
    }

    @Test
    public void addsToExistingIncome() {
        budgeter.addIncome("k", 0.01);
        budgeter.addIncome("k", 5.04);

        assertTrue(budgeter.getIncome().containsValue(5.05));
    }

    @Test
    public void countsTotalExpenses() {
        budgeter.addExpense("k", 40);
        budgeter.addExpense("j", 60);

        assertEquals(100, budgeter.totalExpenses(), 0);
    }

    @Test
    public void countsTotalIncome() {
        budgeter.addIncome("k", 14.10);
        budgeter.addIncome("j", 25.90);

        assertEquals(40, budgeter.totalIncome(), 0);
    }

    @Test
    public void balanceCheckWorks() {
        budgeter.addExpense("a", 100.0);
        budgeter.addIncome("k", 90.0);

        assertEquals(-10.0, budgeter.checkBalance(), 0);

    }

}
