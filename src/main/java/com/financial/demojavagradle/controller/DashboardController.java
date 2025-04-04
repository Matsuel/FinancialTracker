package com.financial.demojavagradle.controller;

import com.financial.demojavagradle.Line;
import com.financial.demojavagradle.db.ExpenseDAO;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.List;

public class DashboardController {

    @FXML
    private PieChart expensePieChart;

    @FXML
    private LineChart<String, Number> expenseLineChart;

    @FXML
    private void initialize() {
        loadPieChartData();
        loadLineChartData();
    }

    private void loadPieChartData() {
        Line recentExpenses = ExpenseDAO.getLastMonthExpenses();

        if (recentExpenses.getTotal() == null) return;

        expensePieChart.getData().add(new PieChart.Data("Logement", recentExpenses.getLogement()));
        expensePieChart.getData().add(new PieChart.Data("Nourriture", recentExpenses.getNourriture()));
        expensePieChart.getData().add(new PieChart.Data("Sorties", recentExpenses.getSorties()));
        expensePieChart.getData().add(new PieChart.Data("Transports", recentExpenses.getTransports()));
        expensePieChart.getData().add(new PieChart.Data("Voyages", recentExpenses.getVoyages()));
        expensePieChart.getData().add(new PieChart.Data("Impots", recentExpenses.getImpots()));
        expensePieChart.getData().add(new PieChart.Data("Autres", recentExpenses.getAutres()));

        expensePieChart.setTitle("Dépenses du mois dernier " + recentExpenses.getPeriod());

        expensePieChart.setLegendVisible(true);

        expensePieChart.setLabelsVisible(true);
    }

    private void loadLineChartData() {
        List<Line> expenses = ExpenseDAO.getExpense();
        String[] categories = {"Housing", "Food", "Exits", "Transport", "Travel", "Taxes", "Other"};

        for (String category : categories) {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(category);
            for (Line line : expenses) {
                switch (category) {
                    case "Housing":
                        series.getData().add(new XYChart.Data<>(line.getPeriod(), line.getLogement()));
                        break;
                    case "Food":
                        series.getData().add(new XYChart.Data<>(line.getPeriod(), line.getNourriture()));
                        break;
                    case "Exits":
                        series.getData().add(new XYChart.Data<>(line.getPeriod(), line.getSorties()));
                        break;
                    case "Transport":
                        series.getData().add(new XYChart.Data<>(line.getPeriod(), line.getTransports()));
                        break;
                    case "Travel":
                        series.getData().add(new XYChart.Data<>(line.getPeriod(), line.getVoyages()));
                        break;
                    case "Taxes":
                        series.getData().add(new XYChart.Data<>(line.getPeriod(), line.getImpots()));
                        break;
                    case "Other":
                        series.getData().add(new XYChart.Data<>(line.getPeriod(), line.getAutres()));
                        break;
                }
            }
            expenseLineChart.getData().add(series);
        }
        expenseLineChart.setTitle("Expenses Over Time");
    }
}
