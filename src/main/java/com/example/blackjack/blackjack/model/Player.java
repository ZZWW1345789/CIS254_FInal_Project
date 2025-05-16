package com.example.blackjack.blackjack.model;

public class Player {

    private int money;

    private int score;

    public Player(int amount)
    {
        this.money = amount;
    }

    private int getScore()
    {
        return this.score;
    }

}
