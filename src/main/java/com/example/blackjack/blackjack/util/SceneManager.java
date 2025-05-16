package com.example.blackjack.blackjack.util;

import com.example.blackjack.blackjack.BlackJackApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * SceneManager
 *  -switching scenes between menu and game
 */
public class SceneManager {

    //---------------Member---------------
    private static Stage primaryStage;


    //---------------Constructor---------------
    /**
     * Use PrimaryStage to store param stage
     * @param stage a Stage object
     */
    public static void setPrimaryStage(Stage stage)
    {
        primaryStage = stage;
    }


    //---------------Methods---------------
    /**
     * Switch Stage to Menu
     *  - Load the menu from menu.fxml, then set menu -> scene -> primaryStage
     * @throws IOException throw exception on loading error
     */
    public static void setMenu() throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(BlackJackApplication.class.getResource("/fxml/menu.fxml"));
            Scene menu = new Scene(fxmlLoader.load(),700,400);
            primaryStage.setScene(menu);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Switch Stage to Game
     *  - Load the game from game.fxml, then set game -> scene -> primaryStage
     * @throws IOException throw exception on loading error
     */
    public static void setGame() throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(BlackJackApplication.class.getResource("/fxml/game.fxml"));
            Scene game = new Scene(fxmlLoader.load(),700,400);
            primaryStage.setScene(game);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
