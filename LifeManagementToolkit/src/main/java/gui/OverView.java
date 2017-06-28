/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import logic.Budgeter;
import logic.Task;
import logic.Tasklist;
import logic.User;

/**
 * Class creates an overview of tasks and budget info to be displayed in a
 * GridPane.
 *
 */
public class OverView {

    private Tasklist tasklist;
    private Budgeter budgeter;
    private User user;

    /**
     * Constructor that sets the objects used to display data the user has given
     * and show calculations based off the data.
     *
     *
     * @param tasklist list of tasks given by the object initializing this
     * object
     * @param budgeter budgeting information given by the object initializing
     * this object
     * @param user user information given by the object initializing this object
     *
     * @see Tasklist
     * @see Budgeter
     * @see User
     */
    public OverView(Tasklist tasklist, Budgeter budgeter, User user) {
        this.tasklist = tasklist;
        this.budgeter = budgeter;
        this.user = user;
    }

    /**
     * Method returns a GridPane view of task and budget information given by
     * the user.
     *
     * @return GridPane of budget and task information
     */
    public Parent getView() {
        GridPane setting = new GridPane();

        int y = 1;

        setting.setAlignment(Pos.CENTER);
        setting.setVgap(10);
        setting.setHgap(10);
        setting.setPadding(new Insets(10, 10, 10, 10));
        setting.add(new Text("Tehtävät"), 0, 0);
        setting.add(new Text("Tehtäväajat"), 1, 0);
        setting.add(new Text("Motiivit"), 2, 0);
        setting.add(new Text("Tulot"), 4, 0);
        setting.add(new Text("Menot"), 5, 0);
        setting.add(new Text("Tulot:"), 7, 0);
        setting.add(new Text("Menot:"), 7, 2);
        setting.add(new Text("Budjetin erotus:"), 7, 4);
        setting.add(new Text(Double.toString(budgeter.totalIncome())), 7, 1);
        setting.add(new Text(Double.toString(budgeter.totalExpenses())), 7, 3);
        setting.add(new Text(Double.toString(budgeter.checkBalance())), 7, 5);

        for (Task t : tasklist.getTasks().values()) {

            setting.add(new Text(t.getName()), 0, y);
            setting.add(new Text(Integer.toString(t.getTime())), 1, y);
            setting.add(new Text(t.getMotive()), 2, y);
            y++;
            if (y == 15) {
                setting.add(new Text("..."), 0, y);
                setting.add(new Text("..."), 1, y);
                y++;
                break;
            }
        }
        y++;
        setting.add(new Text("Kokonaisaika"), 0, y);
        setting.add(new Text(Integer.toString(tasklist.hoursRequired()) + " tuntia & " + Integer.toString(tasklist.minutesRequired()) + " minuuttia"), 1, y);
        y++;
        setting.add(new Text("Tehtävien suorittamiseen kuluvat päivät"), 0, y);
        setting.add(new Text(Integer.toString(tasklist.daysRequired(user.getDailyCapacity()))), 1, y);
        y = 1;

        for (String n : budgeter.getIncome().keySet()) {
            setting.add(new Text(n), 4, y);
            y = y + 2;
            if (y == 15) {
                break;
            }
        }

        y = 2;

        for (Double i : budgeter.getIncome().values()) {
            setting.add(new Text(" " + Double.toString(i)), 4, y);
            y = y + 2;
            if (y == 16) {
                setting.add(new Text("..."), 4, 15);
                break;
            }
        }

        y = 1;

        for (String n : budgeter.getExpenses().keySet()) {
            setting.add(new Text(n), 5, y);
            y = y + 2;
            if (y == 15) {
                break;
            }
        }

        y = 2;

        for (Double i : budgeter.getExpenses().values()) {
            setting.add(new Text(" " + Double.toString(i)), 5, y);
            y = y + 2;
            if (y == 16) {
                setting.add(new Text("..."), 5, 15);
                break;
            }
        }

        return setting;
    }
}
