module org.example.project4_software {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.project4_software to javafx.fxml;
    exports org.example.project4_software;
}