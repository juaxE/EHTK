/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import logic.*;

/**
 *  Class initializes and runs the graphical user interface.
 * @author Juho
 */
public class UserInterface extends Application {

    /**
     *
     * Method initializes and changes the graphical user interface.
     * @param window Stage to display Scenes on.
     * 
     * @see Budgeter
     * @see Tasklist
     * @see OverView
     * @see BudgetView
     * @see TaskInputView
     */
    @Override
    public void start(Stage window) {

        Budgeter budgeter = new Budgeter();
        Tasklist tasklist = new Tasklist();

        BudgetView budgetView = new BudgetView(budgeter);
        TaskInputView taskView = new TaskInputView(tasklist);
        OverView overview = new OverView(tasklist, budgeter);

        BorderPane setting = new BorderPane();

        Label description = new Label("Elämänhallintasovellus(EHTK) on työväline ihmisen arkea tukemaan."
                + "\n" + "Voit valita alareunasta rahan - tai ajanhallintaa edistäviä suunnittelutoimintoja.\n"
                + "Voit myös tallentaa suunnitelmasi tai poistua sovelluksesta.");
        Button budgetWindow = new Button("Rahanhallintaa");
        Button taskWindow = new Button("Aikataulutusta");
        Button overviewWindow = new Button("Yhteenveto");
        Button quit = new Button("Poistu");

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(40);

        menu.getChildren().addAll(budgetWindow, taskWindow, overviewWindow, quit);

        budgetWindow.setOnAction((event) -> setting.setCenter(budgetView.getView()));
        taskWindow.setOnAction((event) -> setting.setCenter(taskView.getView()));
        overviewWindow.setOnAction((event) -> setting.setCenter(overview.getView()));

        quit.setOnAction((event) -> window.close());

        setting.setBottom(menu);
        setting.setCenter(description);

        Scene view = new Scene(setting, 740, 500);

        window.setScene(view);
        window.show();

    }
}
