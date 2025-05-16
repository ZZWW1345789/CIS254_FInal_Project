package com.example.blackjack.blackjack;

import com.example.blackjack.blackjack.util.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BlackJackApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        SceneManager.setPrimaryStage(stage);

        SceneManager.setMenu();

        stage.setTitle("Black Jack");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}