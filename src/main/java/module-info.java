module com.financial.demojavagradle {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;


    opens com.financial.demojavagradle to javafx.fxml;
    exports com.financial.demojavagradle;
    exports com.financial.demojavagradle.controller;
    opens com.financial.demojavagradle.controller to javafx.fxml;
    exports com.financial.demojavagradle.db;
    opens com.financial.demojavagradle.db to javafx.fxml;
}