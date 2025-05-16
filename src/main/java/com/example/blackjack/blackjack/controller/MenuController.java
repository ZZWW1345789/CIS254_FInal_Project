package com.example.blackjack.blackjack.controller;

import com.example.blackjack.blackjack.model.BlackJackGame;
import com.example.blackjack.blackjack.util.SceneManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * MenuController Class
 *  - controller of "menu.fxml"
 */
public class MenuController {

    //---------------Members---------------
    @FXML
    private Button startGameButton;

    @FXML
    private Button exitGameButton;



    //---------------Methods(Control)---------------

    /**
     * onStartGameClick
     *  - when startGameButton clicked, switch stage to game
     * @throws IOException on loading error
     */
    @FXML
    private void onStartGameClick() throws IOException {

        SceneManager.setGame();
    }


    /**
     * onExitGameClick
     *  - when exitGameButton clicked, exit the program
     */
    @FXML
    private void onExitGameClick()
    {
        Platform.exit();
    }
}
