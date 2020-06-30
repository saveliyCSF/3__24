package com.company;

public class Card {
    private Suits suit;     // необходимые поля
    private Ranks rank;

    public Card(Ranks rank, Suits suit) {       //конструктор 52
        this.rank = rank;
        this.suit = suit;
    }

    public Ranks getRank() throws Exception {   // геттер 52
        if (rank != null)
            return rank;
        else throw new Exception("empty rank");
    }
    public Suits getSuit() throws Exception {       // геттер
        if (suit != null)
            return suit;
        else throw new Exception("empty suit");
    }

    public void setRank(Ranks rank) {         // сеттер 52
        this.rank = rank;
    }
    public void setSuit(Suits suit) {               // сеттер
        this.suit = suit;
    }
}
