module com.example.tictactoegame {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;


    opens com.example.tictactoegame to javafx.fxml;
    exports com.example.tictactoegame;
}