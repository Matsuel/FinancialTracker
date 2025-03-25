package com.financial.demojavagradle.controller;

import com.financial.demojavagradle.Line;
import com.financial.demojavagradle.db.ExpenseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Dialog;

import java.io.IOException;

public class ExpenseController extends Dialog<Line>  {


    @FXML
    private TableView<Line> table;

    private final ObservableList<Line> items = FXCollections.observableArrayList();

    public void initialize() {
        items.addAll(ExpenseDAO.getExpense());
        table.setItems(items);
    }


    public TableView<Line> getTable() {
        return table;
    }

    public void setTable(TableView<Line> table) {
        this.table = table;
    }

    @FXML
    private void addExpense() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/financial/demojavagradle/newline.fxml"));
        Parent parent = loader.load();

        // Récupérer le contrôleur de la fenêtre de la nouvelle ligne
        ExpenseDialog expenseDialog = loader.getController();

        // Création de la fenêtre
        Stage stage = new Stage();
        stage.setTitle("Nouvelle ligne");
        stage.setScene(new Scene(parent));
        stage.showAndWait(); // Attendre la fermeture de la fenêtre

        // Récupérer la nouvelle ligne
        Line newLine = expenseDialog.getNewLine();
        if (newLine != null) {
            items.add(newLine); // Ajouter la ligne à l'ObservableList
            table.setItems(items); // Mettre à jour la TableView avec la nouvelle liste
        }
    }
}
