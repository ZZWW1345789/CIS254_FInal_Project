package com.example.blackjack.blackjack.controller;

import com.example.blackjack.blackjack.model.BlackJackGame;
import com.example.blackjack.blackjack.model.Card;
import com.example.blackjack.blackjack.model.Player;
import com.example.blackjack.blackjack.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

/**
 * GameController
 *  - controller of "game.fxml"
 */
public class GameController {

    //---------------Members---------------
    @FXML
    private Button drawButton;

    @FXML
    private Button standButton;

    @FXML
    private HBox aiCardBox;

    @FXML
    private HBox playerCardBox;

    @FXML
    private Label playerScoreLabel;

    @FXML
    private Label dealerScoreLabel;

    private final BlackJackGame blackJackGame = new BlackJackGame();

    private final Player player = blackJackGame.getPlayer();

    private final Player ai = blackJackGame.getAi();

    private final Image cardBack = new Image(getClass().getResource("/image/pokers/card_back.png").toExternalForm());

    @FXML
    private final ImageView hiddenCard = new ImageView(cardBack);


    //---------------initialization(start game)---------------

    /**
     * initialize
     *  - clean UI, restart blackJackGame
     *  - draw two cards for both player and dealer
     *      - player's cards are shown; dealer's cards only show one
     */
    @FXML
    private void initialize() throws IOException {

        cleanCardsDisplay();//clean ui
        blackJackGame.initialize();

        Card aiCard = blackJackGame.drawCard(ai);//dealer draw card
        displayCards(aiCardBox,aiCard);//display dealer's card
        dealerScoreLabel.setText(Integer.toString(ai.getScore()));//update score

        hiddenCard.setFitHeight(90);//hide one card
        hiddenCard.setPreserveRatio(true);
        aiCardBox.getChildren().add(hiddenCard);

        for (int i = 0; i < 2; i++)//draw 2 cards for player, then display
        {
            Card playerCard = blackJackGame.drawCard(player);
            displayCards(playerCardBox,playerCard);
            blackJackGame.checkBust(player);
        }
        playerScoreLabel.setText(Integer.toString(player.getScore()));//update score
        if(blackJackGame.ifBlackJack(player).equals(true))//if hit black Jack, win
        {
            generateInfo("You Win","Black Jack", "You hit 21");
            continueGame();//ask if continue
        }

    }

    //---------------Methods(in game Stage)---------------

    /**
     * onDrawButtonClick
     *  - when drawButton clicked
     *      - check if player hit the maximum cards, if yes throw exception
     *          - if not, draw cards to player's hand
     *              if busted, player loses
     *                  - ask if continued, if yes init the game again, if no return to menu
     *              if black jack, player win
     *                  - ask if continued, if yes init the game again, if no return to menu
     * @throws Exception if player bust
     */
    @FXML
    private void onDrawButtonClick() throws Exception
    {
        try
        {
            if(playerCardBox.getChildren().size() > 5)
            {
                throw new IndexOutOfBoundsException("Can't have more than 6 cards");
            }

            Card playerCard = blackJackGame.drawCard(player);//draw cards

            displayCards(playerCardBox,playerCard);

            playerScoreLabel.setText(Integer.toString(player.getScore()));//update score

            blackJackGame.checkBust(player);//check bust

            if(blackJackGame.ifBlackJack(player).equals(true))//check black jack
            {
                generateInfo("You Win","Black Jack", "You hit 21");
                continueGame();//ask if continue
            }

        }
        catch (IndexOutOfBoundsException e)
        {
            generateError("Error","Exceeded Maximum Cards",e.getMessage());
        }
        catch (IllegalStateException e)
        {
            generateInfo("You Lost","Player lost",e.getMessage());
            continueGame();
        }

    }

    /**
     * onStandButtonClick
     *  - When standButton was clicked
     *      - dealer's turn to draw
     *      - check if dealer bust after draw, if yes player wins
     *      - after dealer's turn ends, get results
     * @throws IOException for loading error
     */
    @FXML
    private void onStandButtonClick() throws IOException {

        Random random = new Random();

        Card aiCard = blackJackGame.drawCard(ai);//draw one card(the hidden one)
        hiddenCard.setImage(aiCard.getImage());//reveal the hidden card

        try
        {
            for(int i = 0; i < random.nextInt(0,3); i++ )//based on random, dealer might draw 0~3 cards
            {
                aiCard = blackJackGame.drawCard(ai);//draw card
                displayCards(aiCardBox,aiCard);
                dealerScoreLabel.setText(Integer.toString(ai.getScore()));//update score
                blackJackGame.checkBust(ai);//check bust
                if(blackJackGame.ifBlackJack(ai))//check black jack
                {
                    generateInfo("Dealer Wins", "Black Jack", "Dealer hits 21");
                }
            }
            dealerScoreLabel.setText(Integer.toString(ai.getScore()));//update score

            gameResult();//pop up game result

            continueGame();//ask if continue



        }
        catch (IllegalStateException e)
        {
            generateInfo("You Win!","Dealer busted","You win the game!!!");

            continueGame();

        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }

    //---------------Methods(util)---------------

    /**
     * generateError
     *  - generate an Error pop up
     * @param title String
     * @param header String
     * @param content String
     */
    @FXML
    private void generateError(String title, String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * generateInfo
     *  - generate an info pop up
     * @param title String
     * @param header String
     * @param content String
     */
    @FXML
    private void generateInfo(String title, String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * displayCards
     *  - display cards on param HBox, through ImageView
     *  - need to pass card for image url
     * @param targetBox HBox
     * @param card Card
     */
    @FXML
    private void displayCards(HBox targetBox, Card card)
    {
        ImageView cardViewCard = new ImageView(card.getImage());
        cardViewCard.setFitHeight(90);
        cardViewCard.setPreserveRatio(true);
        targetBox.getChildren().add(cardViewCard);
    }

    /**
     * cleanCardsDisplay
     *  - clean playerCardBox and aiCardBox
     *  - reset dealer's hidden card
     */
    @FXML
    private void cleanCardsDisplay()
    {
        playerCardBox.getChildren().clear();
        aiCardBox.getChildren().clear();
        hiddenCard.setImage(cardBack);
    }

    /**
     * continueGame
     *  - pop up a confirmation window to ask user if continue
     *      - if yes, restart the game through init
     *      - if no, return to the menu
     * @throws IOException on error loading menu.fxml
     */
    @FXML
    private void continueGame() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Continue Game?");
        alert.setHeaderText("Do you want to start another round?");
        alert.setContentText("yes or no?");

        ButtonType buttonConfirm = new ButtonType("Yes");
        ButtonType buttonCancel = new ButtonType("No");

        alert.getButtonTypes().setAll(buttonConfirm,buttonCancel);

        Optional<ButtonType> input = alert.showAndWait();
        if(input.isEmpty() || input.get().equals(buttonCancel))
        {
            SceneManager.setMenu();
        }
        else
        {
            initialize();
        }

    }

    /**
     * gameResult
     *  - determine win condition through enum, then pop up a corresponding window to notice
     */
    private void gameResult()
    {
        switch (blackJackGame.getResult(player,ai))
        {
            case PLAYER_WIN -> generateInfo("Congrats", "PLayer wins","You hit higher score");
            case DEALER_WIN -> generateInfo("Lost","Player lose", "Dealer hit higher score");
            case DRAW -> generateInfo("Tie","It's a tie","Same score, that's rare");
        }
    }

}
