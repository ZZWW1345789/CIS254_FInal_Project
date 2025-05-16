package com.example.blackjack.blackjack.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BlackJackGame
{
    static String[] patternsSeed  = {"Heart","Spade","Club","Diamond"};

    static ArrayList<Card> deck = new ArrayList<Card>();

    static Player playerOne;

    static Player playerBot;

    private static void createDeck()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 13; j++)
            {
                deck.add(new Card(patternsSeed[i],j+1));
            }
        }

    }

    private static void shuffleDeck()
    {
        Collections.shuffle(deck);
    }


    public static void initGame()
    {
        createDeck();
        shuffleDeck();
        playerOne = new Player(1000);
        playerBot = new Player(1000);

    }


}
