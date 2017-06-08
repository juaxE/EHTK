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

    Budgeter Budgeter;

    @Before
    public void initialize() {
        Budgeter = new Budgeter();
    }

    @Test
    public void addsExpenses() {
        Budgeter.addExpense("a", 100.0);

        assertTrue(Budgeter.getExpenses().containsKey("a"));
        assertTrue(Budgeter.getExpenses().containsValue(100.0));
    }

    @Test
    public void addsToExistingExpense() {
        Budgeter.addExpense("k", 0.01);
        Budgeter.addExpense("k", 5.04);

        assertTrue(Budgeter.getExpenses().containsValue(5.05));
    }

    @Test
    public void addsIncome() {
        Budgeter.addIncome("k", 0.01);

        assertTrue(Budgeter.getIncome().containsKey("k"));
        assertTrue(Budgeter.getIncome().containsValue(0.01));
    }

    @Test
    public void addsToExistingIncome() {
        Budgeter.addIncome("k", 0.01);
        Budgeter.addIncome("k", 5.04);

        assertTrue(Budgeter.getIncome().containsValue(5.05));
    }

    @Test
    public void balanceCheckWorks() {
        Budgeter.addExpense("a", 100.0);
        Budgeter.addIncome("k", 90.0);

        assertEquals(-10.0, Budgeter.checkBalance(), 0);

    }

}
