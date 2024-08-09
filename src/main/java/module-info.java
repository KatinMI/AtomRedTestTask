module com.example.foratomred {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.foratomred to javafx.fxml;
    exports com.example.foratomred;
}