package com.financial.demojavagradle.controller;

import com.financial.demojavagradle.Line;
import com.financial.demojavagradle.db.ExpenseDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static java.lang.Float.parseFloat;

public class ExpenseDialog extends Dialog<Line> {
    @FXML
    private TextField period, total, logement, nourriture, sorties, transports, voyages, impots, autres;

    private Line newLine;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    public ExpenseDialog() {
    }

    public TextField getPeriod() {
        return period;
    }

    public void setPeriod(TextField period) {
        this.period = period;
    }

    public TextField getTotal() {
        return total;
    }

    public void setTotal(TextField total) {
        this.total = total;
    }

    public TextField getLogement() {
        return logement;
    }

    public void setLogement(TextField logement) {
        this.logement = logement;
    }

    public TextField getNourriture() {
        return nourriture;
    }

    public void setNourriture(TextField nourriture) {
        this.nourriture = nourriture;
    }

    public TextField getSorties() {
        return sorties;
    }

    public void setSorties(TextField sorties) {
        this.sorties = sorties;
    }

    public TextField getTransports() {
        return transports;
    }

    public void setTransports(TextField transports) {
        this.transports = transports;
    }

    public TextField getVoyages() {
        return voyages;
    }

    public void setVoyages(TextField voyages) {
        this.voyages = voyages;
    }

    public TextField getImpots() {
        return impots;
    }

    public void setImpots(TextField impots) {
        this.impots = impots;
    }

    public TextField getAutres() {
        return autres;
    }

    public void setAutres(TextField autres) {
        this.autres = autres;
    }

    @FXML
    private void createLine() {
        newLine = new Line();
        newLine.setPeriod(period.getText());
        newLine.setLogement(parseFloat(logement.getText()));
        newLine.setNourriture(parseFloat(nourriture.getText()));
        newLine.setSorties(parseFloat(sorties.getText()));
        newLine.setTransports(parseFloat(transports.getText()));
        newLine.setVoyages(parseFloat(voyages.getText()));
        newLine.setImpots(parseFloat(impots.getText()));
        newLine.setAutres(parseFloat(autres.getText()));
        newLine.setTotal(newLine.getAutres() + newLine.getImpots() + newLine.getLogement() + newLine.getNourriture() + newLine.getSorties() + newLine.getTransports() + newLine.getVoyages());

        ExpenseDAO.insertExpense(newLine);

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    public Line getNewLine() {
        return newLine;
    }


    @FXML
    private void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
