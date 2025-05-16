package com.example.blackjack.blackjack;

import com.example.blackjack.blackjack.util.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * CIS254_FINAL_PROJECT：Black Jack Game
 *
 * @author Z Wang
 * @since 5/16/2025
 *
 * This is a Black Jack game with GUI
 *  - This is the Main program
 *  - resource was from:
 *      https://opengameart.org/content/colorful-poker-card-back
 *      https://code.google.com/archive/p/vector-playing-cards/wikis
 *
 *
 */

/**
 * Application
 */
public class BlackJackApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        SceneManager.setPrimaryStage(stage);//pass the stage to sceneManager

        SceneManager.setMenu();//call the menu(set scene to menu)

        stage.setTitle("Black Jack");//stage title

        stage.show();//show the stage

    }

    public static void main(String[] args) {
        launch();
    }
}