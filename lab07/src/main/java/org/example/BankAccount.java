package org.example;

import java.util.ArrayList;

public class BankAccount {
    public ArrayList<Card> cards;
    public String FIO;

    public BankAccount(String FIO) {
        this.FIO = FIO;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public float getAllBalance(){
        int sum = 0;
        for (var card : cards) {
            sum += card.getBalance();
        }
        return sum;
    }
}
