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
import logic.Budgeter;
import javafx.scene.text.Text;

/**
 * Creates a GridPane element that the user can add budget-related information
 * with.
 *
 */
public class BudgetView {

    private Budgeter budgeter;

    /**
     * Constructor that sets the budgeter attribute for the object.
     *
     * @param budgeter object given from main Stage to add to budget with.
     *
     * @see Budgeter
     */
    public BudgetView(Budgeter budgeter) {
        this.budgeter = budgeter;
    }

    /**
     * Creates a Gridpane that you can input budget information into.
     *
     *
     * @return returns a Gridpane element with capabilities to add to budget
     * list.
     *
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
        Text error = new Text("Puuttellinen syöte");
        error.setFill(Color.RED);
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
            setting.getChildren().remove(error);
            setting.getChildren().remove(numberError);
            setting.getChildren().remove(negativeError);

            if (income.getText().isEmpty() || incomeName.getText().isEmpty()) {
                setting.add(error, 1, 4);
                return;
            }

            try {

                if (Integer.parseInt(income.getText()) < 1) {
                    setting.add(negativeError, 1, 4);
                    return;
                }
                String syote = income.getText();
                if (syote.contains(",")) {
                    syote = syote.replaceAll(",", ".");
                }
                double add = Double.parseDouble(syote);
                String n = incomeName.getText();

                budgeter.addIncome(n, add);

            } catch (Exception e) {
                setting.add(numberError, 1, 4);
                return;

            }
            income.clear();
            incomeName.clear();
        });

        saveExpense.setOnAction((event) -> {
            setting.getChildren().remove(error);
            setting.getChildren().remove(numberError);
            setting.getChildren().remove(negativeError);

            if (expense.getText().isEmpty() || expenseName.getText().isEmpty()) {
                setting.add(error, 2, 4);
                return;
            }

            try {

                if (Integer.parseInt(expense.getText()) < 1) {
                    setting.add(negativeError, 2, 4);
                    return;
                }

                double add = Double.parseDouble(expense.getText());
                String n = expenseName.getText();

                budgeter.addExpense(n, add);

            } catch (Exception e) {
                setting.add(numberError, 2, 4);
                return;

            }
            expense.clear();
            expenseName.clear();
        });

        return setting;
    }
}
