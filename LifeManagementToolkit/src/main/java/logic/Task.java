/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 * Task-object that contains attributes relevant to tasks.
 *
 * @author Juho
 */
public class Task {

    private String name;
    private String motive;
    private int time;

    /**
     * Constructor.
     *
     * @param name name of the task
     * @param motive name of the goal achieved by completing said task
     * @param time time the task takes
     */
    public Task(String name, String motive, int time) {
        this.name = name;
        this.motive = motive;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
