module com.example.testcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testcalculator to javafx.fxml;
    exports com.example.testcalculator;
}