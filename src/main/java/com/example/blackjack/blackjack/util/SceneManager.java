package com.example.blackjack.blackjack.util;

import com.example.blackjack.blackjack.BlackJackApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void setMenu() throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(BlackJackApplication.class.getResource("/fxml/menu.fxml"));
            Scene menu = new Scene(fxmlLoader.load(),800,1000);
            primaryStage.setScene(menu);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void setGame() throws IOException
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(BlackJackApplication.class.getResource("/fxml/game.fxml"));
            Scene game = new Scene(fxmlLoader.load(),800,1000);
            primaryStage.setScene(game);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
