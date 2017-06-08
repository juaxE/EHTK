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
 * Class keeps track of tasks given by the user.
 */
public class Tasklist {

    private Map<String, Task> tasks;

    /**
     * Constructor that initializes the Map attribute.
     */
    public Tasklist() {
        tasks = new HashMap<>();
    }

    /**
     * Adds a task to the Map.
     *
     * @param task task that is added to the Map
     */
    public void addTask(Task task) {
        if (!tasks.containsKey(task.getName())) {
            tasks.put(task.getName(), task);
        }
    }

    /**
     * Removes a given task from the Map.
     *
     * @param name task being removed.
     */
    public void removeTask(String name) {
        if (tasks.containsKey(name)) {
            tasks.remove(name);
        }
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

}
