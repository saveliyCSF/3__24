package com.company;

import java.util.*;

public class MyGameResult {
    private int qOfSteps = 0;
    private MyQueue<Card> deckOfCard;
    private MyStack<Card> pileOfCard;

    public MyGameResult(int qOfSteps, MyQueue<Card> deckOfCards, MyStack<Card> pileOfCards) {
        this.qOfSteps = qOfSteps;
        this.deckOfCard = deckOfCards;
        this.pileOfCard = pileOfCards;
    }

    private static void shuffleCards(List<Card> list) {                           // тасуем колоду
        for (int i = 0; i < list.size() - 1; i++) {
            int position2 = (int) (Math.random() * list.size());
            Card buffCard = list.get(i);
            list.set(i, list.get(position2));
            list.set(position2, buffCard);
        }
    }

    public static Card[] getCards(int q) {
        List<Card> allCards = new ArrayList<>();
        IRankProvider rankProvider = null;
        if (q == 36) {
            rankProvider = Rank36.instance;
        } else if (q == 52) {
            rankProvider = Rank52.instance;
        }
        List<Ranks> listOfAvailableRanks = rankProvider.getAvailableRanks();
        for (Ranks l : listOfAvailableRanks) {
            for (Suits t : Suits.values()) {
                allCards.add(new Card(l, t));
            }
        }
        shuffleCards(allCards);
        Card[] arrayOfCards = new Card[allCards.size()];
        for (int i = 0; i < arrayOfCards.length; i++)
            arrayOfCards[i] = allCards.get(i);
        return arrayOfCards;
    }

    public static MyGameResult solve(Card[] cardArray) throws Exception {
        MyQueue<Card> DeckOfCards = new MyQueue<>();
        MyStack<Card> PileOfCards = new MyStack<>();
        for (Card l : cardArray) {
            DeckOfCards.add(l);
        }
        PileOfCards.push(DeckOfCards.remove());
        int counter = 0;
        int qOfSteps = 0;
        while (counter < DeckOfCards.size()) {
            if (DeckOfCards.peek().getSuit().equals(PileOfCards.peek().getSuit()) ||
                    DeckOfCards.peek().getRank().equals(PileOfCards.peek().getRank())) {
                PileOfCards.push(DeckOfCards.remove());
                counter = 0;
            } else {
                DeckOfCards.add(DeckOfCards.remove());
                ++counter;
            }
            qOfSteps++;
        }
        qOfSteps -= counter;
        MyGameResult gameResult = new MyGameResult(qOfSteps, DeckOfCards, PileOfCards);
        return gameResult;
    }

    public Card[] getDeckOfCard() {
        Card[] arrayDeck = new Card[this.deckOfCard.size()];
        for (int i = 0; i < arrayDeck.length; i++)
            arrayDeck[i] = this.deckOfCard.remove();
        return arrayDeck;
    }
    public Card[] getPileOfCard() {
        Card[] arrayPile = new Card[this.pileOfCard.size()];
        for (int i = 0; i < arrayPile.length; i++)
            arrayPile[i] = this.pileOfCard.pop();
        return arrayPile;
    }
    public int getqOfSteps(){return this.qOfSteps;}
}
