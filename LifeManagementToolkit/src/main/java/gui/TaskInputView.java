/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.Tasklist;
import logic.Task;
import logic.User;

/**
 * Class creates a GridPane element that lets user input tasks.
 *
 * @author Juho
 */
public class TaskInputView {

    private Tasklist tasklist;
    private User user;

    /**
     * Constructor that sets the attribute used to store tasks with.
     *
     * @param tasklist tasklist object given by the initializing object
     * @param user user object given by the initializing object
     *
     * @see Tasklist
     * @see User
     */
    public TaskInputView(Tasklist tasklist, User user) {
        this.tasklist = tasklist;
        this.user = user;
    }

    /**
     * Method returns a GridPane element that lets the user input task
     * information.
     *
     * @return GridPane element to input info with.
     */
    public Parent getView() {

        GridPane setting = new GridPane();

        setting.setAlignment(Pos.CENTER);
        setting.setVgap(10);
        setting.setHgap(10);
        setting.setPadding(new Insets(10, 10, 10, 10));

        Text numberError = new Text("Aikasyöte ei ole numero");
        numberError.setFill(Color.RED);
        Text negativeError = new Text("Syötä vain positiivisia arvoja");
        negativeError.setFill(Color.RED);
        Text error = new Text("Puutteellinen syöte");
        error.setFill(Color.RED);
        Label description = new Label("Syötä tiedossasi olevia tehtäviä \nja arvioi niiden vaatimaa aikaa.");
        Label name = new Label("Tehtävä");
        Label motive = new Label("Motiivi");
        Label timeInfo = new Label("Vaadittu aika (min.)");
        Label userTime = new Label("Syötä minuutteina päivittäin käytettävissä \noleva aika tehtävien tekemiseen.");

        TextField capacity = new TextField();
        TextField time = new TextField();
        TextField taskName = new TextField();
        TextField motiveName = new TextField();

        Button saveTask = new Button("Syötä tehtävä");
        Button saveCapacity = new Button("Tallenna määrä");
        setting.add(description, 0, 0);
        setting.add(name, 0, 1);
        setting.add(timeInfo, 0, 2);
        setting.add(motive, 0, 3);
        setting.add(userTime, 0, 7);

        setting.add(taskName, 1, 1);
        setting.add(time, 1, 2);
        setting.add(motiveName, 1, 3);
        setting.add(capacity, 1, 7);

        setting.add(saveTask, 1, 4);
        setting.add(saveCapacity, 1, 8);

        saveTask.setOnAction((event) -> {
            setting.getChildren().remove(error);
            setting.getChildren().remove(numberError);
            setting.getChildren().remove(negativeError);

            if (taskName.getText().isEmpty() || time.getText().isEmpty()) {         //Motive not included in check as a design choice.
                setting.add(error, 1, 5);
                return;
            }

            try {
                int t = Integer.parseInt(time.getText());
                if (t < 1) {
                    setting.add(negativeError, 1, 5);
                    return;
                } else {
                    String n = taskName.getText();
                    String m = motiveName.getText();

                    tasklist.addTask(new Task(n, m, t));
                }

            } catch (Exception e) {
                setting.add(numberError, 1, 5);
                return;
            }
            time.clear();
            taskName.clear();
            motiveName.clear();
        });

        saveCapacity.setOnAction((event) -> {
            setting.getChildren().remove(error);
            setting.getChildren().remove(numberError);
            setting.getChildren().remove(negativeError);

            if (capacity.getText().isEmpty()) {
                setting.add(error, 1, 9);
                return;
            }

            try {
                int c = Integer.parseInt(capacity.getText());
                if (c < 1) {
                    setting.add(negativeError, 1, 9);
                    return;
                } else {
                    user.setDailyCapacity(c);
                }

            } catch (Exception e) {

                setting.add(numberError, 1, 9);
                return;

            }
            capacity.clear();
        });

        return setting;
    }
}
