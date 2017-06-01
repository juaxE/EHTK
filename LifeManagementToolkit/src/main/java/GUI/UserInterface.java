/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
 *
 * @author Juho
 */
public class UserInterface extends Application {

    @Override
    public void start(Stage window) {

        Budgeter budgeter = new Budgeter();
        Tasklist tasklist = new Tasklist();
        
        BudgetView budgetView = new BudgetView(budgeter);
        TaskView taskView = new TaskView(tasklist);
        
        BorderPane setting = new BorderPane();

        Label description = new Label("Elämänhallintasovellus(EHTK) on työväline ihmisen arkea tukemaan."
                + "\n" + "Voit valita alareunasta rahan - tai ajanhallintaa edistäviä suunnittelutoimintoja.\n"
                + "Voit myös tallentaa suunnitelmasi tai poistua sovelluksesta.");
        Button budgetWindow = new Button("Rahanhallintaa");
        Button taskWindow = new Button("Aikataulutusta");
        Button quit = new Button("Poistu");
        Button save = new Button("Tallenna tiedostoon");

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(40);

        menu.getChildren().addAll(budgetWindow, taskWindow, save, quit);
       
        budgetWindow.setOnAction((event) -> setting.setCenter(budgetView.getView()));
        
        quit.setOnAction((event) -> window.close());
        
        setting.setBottom(menu);
        setting.setCenter(description);
        
        Scene view = new Scene(setting, 600, 450);
        
        window.setScene(view);
        window.show();
        

    }
}
