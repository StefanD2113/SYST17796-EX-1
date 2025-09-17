/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * 
 * @author srinivsi
 * @modifier Stefan ,ID: 991725603  - Modified on 2025-09-17
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        // create a hand of 7 random cards
        Card[] magicHand = new Card[7];
        
        for (int i = 0; i < magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // 1–13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // pick random suit
            magicHand[i] = c;
        }

        // Ask user for a card
        System.out.print("Pick a card value (1-13): ");
        int userValue = sc.nextInt();
        System.out.print("Pick a suit (hearts, diamonds, clubs, spades): ");
        String userSuit = sc.next();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search for user's card in magicHand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() && 
                c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card is in the magic hand! You win!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Lucky card (hard-coded: 2 of clubs)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("clubs");

        boolean luckyFound = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() && 
                c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

        if (luckyFound) {
            System.out.println("The lucky card (2 of clubs) is in the hand! Winner!");
        } else {
            System.out.println("The lucky card (2 of clubs) is not in the hand.");
        }
    }
}

