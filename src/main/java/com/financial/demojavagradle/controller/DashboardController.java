package com.financial.demojavagradle.controller;

import com.financial.demojavagradle.Line;
import com.financial.demojavagradle.db.ExpenseDAO;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class DashboardController {

    @FXML
    private PieChart expensePieChart;

    @FXML
    private void initialize() {
        loadPieChartData();
    }

    private void loadPieChartData() {
        Line recentExpenses = ExpenseDAO.getLastMonthExpenses();

        if (recentExpenses.getTotal() == null) return;

        System.out.println(recentExpenses);
        expensePieChart.getData().add(new PieChart.Data("Logement", recentExpenses.getLogement()));
        expensePieChart.getData().add(new PieChart.Data("Nourriture", recentExpenses.getNourriture()));
        expensePieChart.getData().add(new PieChart.Data("Sorties", recentExpenses.getSorties()));
        expensePieChart.getData().add(new PieChart.Data("Transports", recentExpenses.getTransports()));
        expensePieChart.getData().add(new PieChart.Data("Voyages", recentExpenses.getVoyages()));
        expensePieChart.getData().add(new PieChart.Data("Impots", recentExpenses.getImpots()));
        expensePieChart.getData().add(new PieChart.Data("Autres", recentExpenses.getAutres()));

        expensePieChart.setTitle("Dépenses du mois dernier" + recentExpenses.getPeriod());

        expensePieChart.setLegendVisible(true);

        expensePieChart.setLabelsVisible(true);
    }
}
