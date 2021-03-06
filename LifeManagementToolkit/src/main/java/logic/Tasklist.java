/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     * Adds a task to the Map or adds to an existing one.
     *
     * @param task task that is added to the Map
     */
    public void addTask(Task task) {
        if (!tasks.containsKey(task.getName())) {
            tasks.put(task.getName(), task);

        } else {
            Task t = tasks.get(task.getName());
            int m = t.getTime() + task.getTime();
            tasks.get(task.getName()).setTime(m);
            tasks.get(task.getName()).setMotive(task.getMotive());
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

    /**
     * Counts the total time needed to complete tasks given.
     *
     * @return returns time counted in minutes
     */
    public int totalTime() {

        int total = 0;
        for (Task t : tasks.values()) {
            total += t.getTime();
        }
        return total;

    }

    /**
     * Counts the full hours needed to complete tasks given.
     *
     * @return returns hours counted
     */
    public int hoursRequired() {
        int time = totalTime();
        int hours = time / 60;
        return hours;

    }

    /**
     * Counts the minutes needed to complete tasks given.
     *
     * @return returns minutes counted
     */
    public int minutesRequired() {
        int time = totalTime();
        int minutes = time % 60;
        return minutes;
    }

    /**
     * Counts the days needed to complete tasks given with the time given to it.
     *
     * @param minutesPerDay minutes given to the method as the daily time
     * available by user.
     *
     * @return returns days counted
     */
    public int daysRequired(int minutesPerDay) {
        int days = totalTime() / minutesPerDay;

        if (totalTime() % minutesPerDay != 0 && totalTime() > minutesPerDay) {
            days++;
        }
        return days;
    }

}
