package com.example.blackjack.blackjack.model;

import javafx.scene.image.Image;

public class Card {



    private String pattern;

    private int point;

    private String imageUrl;

    public Card(String pattern, int point)
    {
        this.pattern = pattern;
        this.point = point;
    }

    @Override
    public String toString() {
        return String.format("%s %d",pattern,point);
    }
}
