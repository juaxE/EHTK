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
public class TasklistTest {

    private Tasklist tasklist;

    @Before
    public void initialize() {
        tasklist = new Tasklist();
    }

    @Test
    public void initializedEmpty() {
        assertEquals(0, tasklist.getTasks().size());
    }

    @Test
    public void tasksIncrease() {
        tasklist.addTask(new Task("a", "b", 1));

        assertEquals(1, tasklist.getTasks().size());
    }

    @Test
    public void taskKeyIsCorrect() {
        tasklist.addTask(new Task("a", "b", 1));

        assertTrue(tasklist.getTasks().containsKey("a"));
    }
    
    
    @Test
    public void taskValuesAreCorrect() {
        tasklist.addTask(new Task("a", "b", 1));

        tasklist.getTasks().values().equals(new Task("a", "b", 1));
    }

    @Test
    public void taskDeletes() {
        tasklist.addTask(new Task("a", "b", 1));
        tasklist.removeTask("a");

        assertEquals(0, tasklist.getTasks().size());
    }
    
    @Test
    public void countsTotalTime(){
        tasklist.addTask(new Task("ok", "jee", 200));
        tasklist.addTask(new Task("juuh", "juup", 300));
        
        assertEquals(500, tasklist.totalTime());
    }
    
    @Test
    public void countsHours(){
        tasklist.addTask(new Task("ok", "jee", 200));
        tasklist.addTask(new Task("juuh", "juup", 30));
        
        assertEquals(3, tasklist.hoursRequired());
    }
    
    @Test
    public void countsMinutes(){
        tasklist.addTask(new Task("ok", "jee", 200));
        tasklist.addTask(new Task("juuh", "juup", 30));
        
        assertEquals(50, tasklist.minutesRequired());
    }
}
