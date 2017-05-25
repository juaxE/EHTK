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
public class Tasklist {

    private Map<String, Task> tasks;

    public Tasklist() {
        tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        if (!tasks.containsKey(task.getName())) {
            tasks.put(task.getName(), task);
        }
    }

    public void removeTask(String name) {
        if (tasks.containsKey(name)) {
            tasks.remove(name);
        }
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(Map<String, Task> tasks) {
        this.tasks = tasks;
    }

}
