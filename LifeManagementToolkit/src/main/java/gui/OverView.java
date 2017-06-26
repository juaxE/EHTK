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

/**
 * Class creates an overview of tasks and budget info to be displayed in a
 * GridPane.
 *
 */
public class OverView {

    private Tasklist tasklist;
    private Budgeter budgeter;

    /**
     * Constructor that sets the objects used to display and modify information
     * with.
     *
     * @param tasklist list of tasks given by the object initializing this
     * method
     * @param budgeter budgeting information given by the object initializing
     * this method
     *
     * @see Tasklist
     * @see Budgeter
     */
    public OverView(Tasklist tasklist, Budgeter budgeter) {
        this.tasklist = tasklist;
        this.budgeter = budgeter;
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
        setting.setGridLinesVisible(true);
        setting.setAlignment(Pos.CENTER);
        setting.setVgap(10);
        setting.setHgap(10);
        setting.setPadding(new Insets(10, 10, 10, 10));

        setting.add(new Text("Tehtävät"), 0, 0);
        setting.add(new Text("Tehtäväajat"), 1, 0);
        setting.add(new Text("Tulot"), 3, 0);
        setting.add(new Text("Menot"), 4, 0);
        setting.add(new Text("Budjetin erotus:"), 6, 0);

        for (Task t : tasklist.getTasks().values()) {

            setting.add(new Text(t.getName()), 0, y);
            setting.add(new Text(Integer.toString(t.getTime())), 1, y);
            y++;
        }

        y = 1;

        for (String n : budgeter.getIncome().keySet()) {
            setting.add(new Text(n), 3, y);
            y = y + 2;
        }

        y = 2;

        for (Double i : budgeter.getIncome().values()) {
            setting.add(new Text(" " + Double.toString(i)), 3, y);
            y = y + 2;
        }
        y = 1;
        for (String n : budgeter.getExpenses().keySet()) {
            setting.add(new Text(n), 4, y);
            y = y + 2;
        }

        y = 2;

        for (Double i : budgeter.getExpenses().values()) {
            setting.add(new Text(" " + Double.toString(i)), 4, y);
            y = y + 2;
        }

        setting.add(new Text(Double.toString(budgeter.checkBalance())), 6, 1);

        return setting;
    }
}
