package com.company;

import java.util.ArrayList;
import java.util.List;

public enum Ranks {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");
    private String rank;

    Ranks(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}

interface IRankProvider {
    List<Ranks> getAvailableRanks();
    int size();
}

class Rank36 implements IRankProvider {
    @Override
    public List<Ranks> getAvailableRanks() {
        List<Ranks> l = new ArrayList<>();
        l.add(Ranks.SIX);
        l.add(Ranks.SEVEN);
        l.add(Ranks.EIGHT);
        l.add(Ranks.NINE);
        l.add(Ranks.TEN);
        l.add(Ranks.JACK);
        l.add(Ranks.QUEEN);
        l.add(Ranks.KING);
        l.add(Ranks.ACE);
        return l;
    }
    @Override
    public int size() {
        return 36;
    }
    public static final Rank36 instance = new Rank36();
}

class Rank52 implements IRankProvider {
    @Override
    public List<Ranks> getAvailableRanks() {
        List<Ranks> l = new ArrayList<>();

        for (Ranks rank : Ranks.values()) {
            l.add(rank);
        }
        return l;
    }

    @Override
    public int size() {
        return 52;
    }

    public static final Rank52 instance = new Rank52();
}