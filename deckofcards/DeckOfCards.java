/*@Purpose : Write a Program DeckOfCards.java, to initialize deck of cards having suit
 *("Clubs", "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8",
 *"9", "10", "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random
 *method and then distribute 9 Cards to 4 Players and Print the Cards received by
 *the 4 Players using 2D Array...
 *@file : Deck Of Cards
 *@author : Kishlay Kishan
 */
package com.blz.deckofcards;

import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCards {

	Scanner scanner = new Scanner(System.in);
	public ArrayList<String> cardsDeck = new ArrayList<String>();

	public ArrayList<String> makeADeck() {
		String[] shapes = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace" };
		int numOfCards = shapes.length * ranks.length;
		System.out.println("Number of cards in the deck:" + numOfCards);

		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < shapes.length; j++) {
				cardsDeck.add(ranks[i] + "->" + shapes[j]);
			}
		}
		toDisplay(cardsDeck);
		return cardsDeck;
	}

	/*
	 * @Purpose : To Shuffle Cards
	 * 
	 * @param :Array Having Deck Of Cards
	 */
	public static void toshuffle(ArrayList<String> cardsDeck, int player) {
		System.out.println("Shuffling The Cards Before Distribution");
		ArrayList<String> temp = new ArrayList<String>();
		while (!cardsDeck.isEmpty()) {
			int loc = (int) (Math.random() * cardsDeck.size());
			temp.add(cardsDeck.get(loc));
			cardsDeck.remove(loc);
		}
		cardsDeck = temp;
		toDisplay(cardsDeck);
		cardDistribution(cardsDeck, player);
	}

	/*
	 * @Purpose : To Display Deck Elements
	 * 
	 * @param : Array Having Deck Of Cards
	 */
	private static void toDisplay(ArrayList<String> cardsDeck) {
		System.out.println("Cards in Deck ");
		for (String element : cardsDeck) {
			System.out.print("\t" + element);
		}
		System.out.println();
	}

	/*
	 * @Purpose : Taking Number Of Players Play Minimum 2 ,3 and 4 Players are
	 * Playing in the Card Game
	 */
	private void noOfPlayers() {
		System.out.println("\n Enter number of players minimum 2 or 3 or 4");
		int player = scanner.nextInt();
		if (player >= 2 && player <= 4) {
			System.out.println(player + " Players Will Play The Game");
			sequenceOfPlay(player);

		} else {
			System.out.println("Please Enter Number Of Players In The Range");
			this.noOfPlayers();
		}
	}

	public void sequenceOfPlay(int player) {
		toshuffle(cardsDeck, player);
	}

	/*
	 * @Purpose: Distribution Of Cards In Players
	 * 
	 * @param : Array Having Deck Of Cards
	 */
	private static void cardDistribution(ArrayList<String> cardsDeck, int player) {
		ArrayList<String> storageDeck = new ArrayList<>();
		for (int i = 0; i < cardsDeck.size(); i++) {
			storageDeck.add(cardsDeck.get(i));
		}
		for (int i = 0; i < player; i++) {
			System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
			for (int j = 0; j < 9; j++) {
				System.out.print("\t" + storageDeck.get(i + j * player));
			}
		}
		System.out.println();
	}

	/*
	 * @Purpose : Printing Welcome Message And Calling Functions To Main Method
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Deck of Cards Program");
		DeckOfCards deck = new DeckOfCards();
		deck.makeADeck();
		deck.noOfPlayers();
	}
}