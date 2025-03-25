package com.financial.demojavagradle.db;

import com.financial.demojavagradle.Line;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpenseDAO {

    public static void insertExpense(Line line) {
        String sql = "INSERT INTO expense(date, housing, food, goingOut, transportation, travel,tax, other) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = Objects.requireNonNull(Database.connect()).prepareStatement(sql);
            pstmt.setString(1, line.getPeriod());
            pstmt.setDouble(2, line.getLogement());
            pstmt.setDouble(3, line.getNourriture());
            pstmt.setDouble(4, line.getSorties());
            pstmt.setDouble(5, line.getTransports());
            pstmt.setDouble(6, line.getVoyages());
            pstmt.setDouble(7, line.getImpots());
            pstmt.setDouble(8, line.getAutres());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Line> getExpense() {
        String sql = "SELECT * FROM expense";
        List<Line> expenses = new ArrayList<Line>();
        try {
            PreparedStatement pstmt = Objects.requireNonNull(Database.connect()).prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Line line = new Line();
                line.setPeriod(rs.getString("date"));
                line.setLogement(rs.getFloat("housing"));
                line.setNourriture(rs.getFloat("food"));
                line.setSorties(rs.getFloat("goingOut"));
                line.setTransports(rs.getFloat("transportation"));
                line.setVoyages(rs.getFloat("travel"));
                line.setImpots(rs.getFloat("tax"));
                line.setAutres(rs.getFloat("other"));
                line.setTotal(rs.getFloat("housing") + rs.getFloat("food") + rs.getFloat("goingOut") + rs.getFloat("transportation") + rs.getFloat("travel") + rs.getFloat("tax") + rs.getFloat("other"));
                expenses.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expenses;
    }
}
