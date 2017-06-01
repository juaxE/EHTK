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
import logic.Budgeter;

/**
 *
 * @author Juho
 */
public class BudgetView {

    private Budgeter budgeter;

    public BudgetView(Budgeter budgeter) {
        this.budgeter = budgeter;
    }

    public Parent getView() {
        GridPane setting = new GridPane();

        setting.setAlignment(Pos.CENTER);
        setting.setVgap(10);
        setting.setHgap(10);
        setting.setPadding(new Insets(10, 10, 10, 10));

        Label error = new Label("Määräsyöte ei ole numero");
        Label description = new Label("Syötä suunniteltavan kuukauden tulot ja menot kuvauksineen");
        Label instructIncome = new Label("Tulo");
        Label instructExpense = new Label("Meno");
        Label amount = new Label("Määrä");
        Label name = new Label("Kuvaus");

        TextField income = new TextField();
        TextField expense = new TextField();
        TextField incomeName = new TextField();
        TextField expenseName = new TextField();

        Button saveIncome = new Button("Syötä tulo");
        Button saveExpense = new Button("Syötä meno");

        setting.add(description, 0, 0);
        setting.add(amount, 0, 2);
        setting.add(name, 0, 1);
        setting.add(instructIncome, 1, 0);
        setting.add(instructExpense, 2, 0);

        setting.add(incomeName, 1, 1);
        setting.add(expenseName, 2, 1);
        setting.add(income, 1, 2);
        setting.add(expense, 2, 2);

        setting.add(saveIncome, 1, 3);
        setting.add(saveExpense, 2, 3);

        saveIncome.setOnAction((event) -> {
            try {
                setting.getChildren().remove(error);

                double add = Double.parseDouble(income.getText());
                String n = incomeName.getText();

                budgeter.addIncome(n, add);

            } catch (Exception e) {
                setting.add(error, 1, 4);
                return;

            }
            income.clear();
            incomeName.clear();
        });

        saveExpense.setOnAction((event) -> {
            try {
                setting.getChildren().remove(error);

                double add = Double.parseDouble(expense.getText());
                String n = expenseName.getText();

                budgeter.addExpense(n, add);

            } catch (Exception e) {
                setting.add(error, 2, 4);
                return;

            }
            expense.clear();
            expenseName.clear();
        });

        return setting;
    }
}
