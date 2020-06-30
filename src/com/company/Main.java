package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Введите размерность колоды: ");
        Card[] cardArray = GameResult.getCards(new Scanner(System.in).nextInt());
        GameResult gameResult = GameResult.solve(cardArray);
        //MyGameResult myGameResult = MyGameResult.solve(cardArray);
        Card[] deckResult = gameResult.getDeckOfCard();
        Card[] pileResult = gameResult.getPileOfCard();

        System.out.println("qOfSteps: " + gameResult.getqOfSteps());
        System.out.println("Cards-Leftovers:");
        for (int i = 0; i < deckResult.length; i++) {
            System.out.println(deckResult[i].getRank().getRank() + " " + deckResult[i].getSuit().getSuit());
        }
        System.out.println("Cards on the desk:");
        for (int i = 0; i < pileResult.length; i++) {
            System.out.println(pileResult[i].getRank().getRank()+" "+ pileResult[i].getSuit().getSuit());
        }
    }
}