package com.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final int easy = 10, medium = 100, hard = 1000;
		boolean wantsToQuit = false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Guess the Number!\r\nMade by Evan Crabtree\r\n2019 v1.1\r\n");
		
		while (!wantsToQuit) {
			int difficulty = easy;
			
			int x = (int)(difficulty * Math.random());
			int n, guesses = 5;
			boolean won = false;
			String input;
			
			while (guesses > 0 && !won) {
				System.out.print("Guesses: " + guesses + "\t");
				System.out.print("Guess the number: ");
				
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
