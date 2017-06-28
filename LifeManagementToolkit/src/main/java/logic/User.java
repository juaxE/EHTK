/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * Class to save user related data.
 */
public class User {

    private int dailyCapacity;

    /**
     *  Constructor sets the dailyCapacity at one to avoid dividing by zero.
     * 
     */
    public User() {
        this.dailyCapacity = 1;
    }

    public int getDailyCapacity() {
        return dailyCapacity;
    }

    public void setDailyCapacity(int dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }

}
