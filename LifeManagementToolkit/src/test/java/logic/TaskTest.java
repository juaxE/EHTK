package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juho
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {

    private Task task;

    @Before
    public void initialize() {
        this.task = new Task("Cleaning", "Cleaning my house", 120);
    }

    @Test
    public void correctName() {
        assertTrue(task.getName().equals("Cleaning"));

    }

    @Test
    public void correctDescr() {
        assertTrue(task.getMotive().equals("Cleaning my house"));
    }

    @Test
    public void correctTime() {
        assertEquals(120, task.getTime());
    }
}
