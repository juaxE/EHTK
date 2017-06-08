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

/**
 * Class creates a GridPane element that lets user input tasks.
 * @author Juho
 */
public class TaskView {

    private Tasklist tasklist;

    /**
     * Constructor that sets the attribute used to store tasks with.
     * @param tasklist
     */
    public TaskView(Tasklist tasklist) {
        this.tasklist = tasklist;
    }

    /**
     * Method returns a GridPane element that lets the user input task information.
     * @return GridPane element to input info with.
     */
    public Parent getView() {
        GridPane setting = new GridPane();

        setting.setAlignment(Pos.CENTER);
        setting.setVgap(10);
        setting.setHgap(10);
        setting.setPadding(new Insets(10, 10, 10, 10));

        Text error = new Text("Määräsyöte ei ole numero");
        error.setFill(Color.RED);
        Label description = new Label("Syötä tiedossasi olevia tehtäviä ja arvioi niiden vaatimaa aikaa.");
        Label name = new Label("Tehtävä");
        Label motive = new Label("Motiivi");
        Label timeInfo = new Label("Vaadittu aika (min.)");

        TextField time = new TextField();
        TextField taskName = new TextField();
        TextField motiveName = new TextField();
        Button saveTask = new Button("Syötä tehtävä");

        setting.add(description, 0, 0);
        setting.add(name, 0, 1);
        setting.add(timeInfo, 0, 2);
        setting.add(motive, 0, 3);

        setting.add(taskName, 1, 1);
        setting.add(time, 1, 2);
        setting.add(motiveName, 1, 3);
        setting.add(saveTask, 1, 4);

        saveTask.setOnAction((event) -> {
            try {
                setting.getChildren().remove(error);

                int t = Integer.parseInt(time.getText());
                String n = taskName.getText();
                String m = motiveName.getText();

                tasklist.addTask(new Task(n, m, t));

            } catch (Exception e) {
                setting.add(error, 1, 4);
                return;

            }
            time.clear();
            taskName.clear();
            motiveName.clear();
        });

        return setting;
    }
}
