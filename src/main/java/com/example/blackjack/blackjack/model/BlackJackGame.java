package com.example.blackjack.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * BlackJackGame class
 *  - main body of the game
 */
public class BlackJackGame
{

    //---------------Members---------------

    private final String[] patternsSeed  = {"hearts","spades","clubs","diamonds"};

    private final ArrayList<Card> deck = new ArrayList<Card>();//store cards

    private final Player playerOne = new Player();//a player

    private final Player playerBot = new Player();//a bot player

    public enum GameResult
    {
        PLAYER_WIN,
        DEALER_WIN,
        DRAW
    }



    //---------------Constructor---------------
    /**
     * initialized the game while being constructed
     */
    public BlackJackGame()
    {
        initialize();
    }

    //---------------initialization---------------
    public void initialize()
    {
        if(deck.isEmpty())//if the deck is empty
        {
            createDeck();
            shuffleDeck();
            playerOne.setScore(0);//set scores to 0
            playerBot.setScore(0);//set scores to 0
        }
        else    //if deck exists
        {
            deck.clear();//clean deck
            createDeck();
            shuffleDeck();
            playerOne.setScore(0);//set scores to 0
            playerBot.setScore(0);//set scores to 0
        }
    }

    //---------------Methods---------------

    /**
     * createDeck
     *  = create deck with a nest loop
     *      - outer loop switch patterns
     *      - inner loop adds card from 1 to 13
     */
    private void createDeck()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 13; j++)
            {
                deck.add(new Card(patternsSeed[i],j+1));
            }
        }

    }

    /**
     * shuffleDeck
     *  - shuffle the elements of the deck
     */
    private void shuffleDeck()
    {
        Collections.shuffle(deck);
    }


    /**
     * drawCard
     *  - draw a card from the deck then remove it
     *  - give card's point to param player's score
     *  - return the card that has been drawled
     * @param player a Player object
     * @return a Card object
     */
    public Card drawCard(Player player)
    {
        Card card = deck.removeFirst();//store drawled card
        int score = player.getScore() + card.getPoint();//store total score

        player.setScore(score);

        return card;
    }

    /**
     * checkBust
     *  - check if the param player busted 21
     *      - if busted, then throw IllegalStateException
     * @param player a Player object
     */
    public void checkBust(Player player)
    {
        if(player.getScore() > 21)
        {
            throw new IllegalStateException("You busted!");
        }
    }

    /**
     * ifBlackJack
     *  - check if the param player hit 21(Black Jack)
     *      - if it does, return ture
     *      - if no, return false
     * @param player a Player object
     * @return Boolean
     */
    public Boolean ifBlackJack(Player player)
    {
        if(player.getScore() == 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //---------------Gets---------------

    /**
     * getPlayer
     *  get the player(user)
     * @return Player object
     */
    public Player getPlayer()
    {
        return playerOne;
    }

    /**
     * getAi
     *  - get the player(bot)
     * @return Player object
     */
    public Player getAi()
    {
        return playerBot;
    }

    /**
     * getResult
     *  - determine win/lose between param players
     *      - if player score > dealer, player wins
     *      - if player score == dealer, it is a tie
     *      - if player scores < dealer. then the player loses
     * @param player a Player object
     * @param dealer a Player object
     * @return an enum object
     */
    public GameResult getResult(Player player, Player dealer)
    {
        if(player.getScore() == dealer.getScore())
        {
            return GameResult.DRAW;
        }
        else if (player.getScore() > dealer.getScore())
        {
            return GameResult.PLAYER_WIN;
        }
        else
        {
            return GameResult.DEALER_WIN;
        }

    }

}
