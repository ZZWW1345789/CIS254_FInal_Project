package com.example.blackjack.blackjack.model;

import javafx.scene.image.Image;

/**
 * Card Class
 *  - Each card has its own:
 *      - pattern
 *      - point
 *      - image
 */
public class Card {


    //---------------Members---------------
    private String pattern;

    private int point;

    private Image image;

    //---------------Constructor---------------
    /**
     *  Each card has its own pattern and points.
     *      - create the Card object with patterns and points
     *      - image will be loaded based on patterns and points
     * @param pattern a String variable
     * @param point an int variable
     */
    public Card(String pattern, int point)
    {
        this.pattern = pattern;
        this.point = point;
        this.image = new Image(getClass().getResource(String.format("/image/pokers/%d_of_%s.png",point,pattern)).toExternalForm());
    }

    //---------------Gets---------------

    /**
     * get the image url
     * @return the image url
     */
    public Image getImage()
    {
        return this.image;
    }


    /**
     * get card's point
     * @return card's point, an int variable
     */
    public int getPoint()
    {
        return this.point;
    }


    /**
     * convert Card to String
     * @return card name, a String
     */
    @Override
    public String toString() {
        return String.format("%s %d",pattern,point);
    }
}
