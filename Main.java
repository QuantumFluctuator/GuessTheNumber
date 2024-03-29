package com.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int easy = 10, medium = 100, hard = 1000;
		boolean wantsToQuit = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Guess the Number Java Edition!\r\nMade by Evan Crabtree\r\n2019 v1.1\r\n");
		
		while (!wantsToQuit) {
			int diff, difficulty;
			System.out.print("(1) Easy\r\n(2) Medium\r\n(3) Hard\r\n(0) Custom\r\n\t\tChoose a difficulty: ");
			diff = sc.nextInt();
			
			switch (diff) {
			case 1:
				difficulty = easy;
				break;
			case 2:
				difficulty = medium;
				break;
			case 3:
				difficulty = hard;
				break;
			case 0:
				System.out.print("\t\tEnter a maximum number: ");
				difficulty = sc.nextInt();
				while (difficulty < 5) {
					System.out.print("\t\tSorry, the number must be 5 or greater: ");
					difficulty = sc.nextInt();
				}
				System.out.println();
				break;
			default:
				difficulty = medium;
				break;
			}
			
			int x = (int)(difficulty * Math.random());
			int n, guesses = ((int)Math.sqrt(difficulty/8))+2;
			boolean won = false;
			String input;
			
			System.out.print("Number is between 0 and " + difficulty + "\r\n\r\n");
			
			while (guesses > 0 && !won) {
				System.out.print("Guesses: " + guesses + "\tGuess the number: ");
				
				n = sc.nextInt();
				guesses--;
				System.out.println();
				
				if (n == x) {
					won = true;
				} else if (n > x) {
					System.out.println("\t\tYour guess is too high\r\n");
				} else if (n < x) {
					System.out.println("\t\tYour guess is too low\r\n");
				}
			}
			
			System.out.println("The number: " + x);
			
			if (won) {
				System.out.println("\t\tYou win!");
			} else {
				System.out.println("\t\tYou lose!");
			}
			
			System.out.print("\t\tWould you like to play again? Y/N: ");
			input = sc.next();
			
			if (!input.contains("Y") && !input.contains("y")) {
				wantsToQuit = true;
				System.out.println();
			}
		}
		
		System.out.println("\t\tThanks for playing!");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
