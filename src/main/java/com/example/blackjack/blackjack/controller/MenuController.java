package com.example.blackjack.blackjack.controller;

import com.example.blackjack.blackjack.model.BlackJackGame;
import com.example.blackjack.blackjack.util.SceneManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button startGameButton;

    @FXML
    private Button exitGameButton;



    @FXML
    private void onStartGameClick() throws IOException {

        BlackJackGame.initGame();
        SceneManager.setGame();
    }

    @FXML
    private void onExitGameClick()
    {
        Platform.exit();
    }
}
