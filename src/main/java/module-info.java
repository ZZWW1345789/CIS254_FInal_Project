module com.example.blackjack.blackjack {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.blackjack.blackjack.controller to javafx.fxml;
    exports com.example.blackjack.blackjack;
}