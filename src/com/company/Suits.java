package com.company;

public enum Suits {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");

    private String suit;

    Suits(String suit){
        this.suit = suit;
    }

    public String getSuit(){ return suit;}
}