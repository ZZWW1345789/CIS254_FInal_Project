package com.example.blackjack.blackjack.model;

import javax.management.ConstructorParameters;

/**
 * Player class
 *  each player has its own score
 */
public class Player {

    //---------------Member---------------
    private int score;

    //---------------Constructor---------------
    /**
     * set player's score to 0
     */
    public Player()
    {
        this.score = 0;//set score to 0
    }

    //---------------Sets---------------
    /**
     * setScore
     *  - set score through param value
     * @param score an int variable
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    //---------------Gets---------------
    /**
     * getScore
     *  - get score from player
     * @return player's score, int variable
     */
    public int getScore()
    {
        return this.score;
    }

}
