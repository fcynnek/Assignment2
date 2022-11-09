package com.fcynnek.assignment2;

import java.util.Random;
import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {

		System.out.println("Welcome to \"Higher / Lower Guessing Game\"");
		System.out.println("You have 5 chances to guess the correct number.");
		System.out.println("Pick a number between 1 and 100:");

		// Saving the result of the method into a variable to be called later
		int theRandomNumber = creatingRandomNumber(1, 100);
		System.out.println(theRandomNumber);

		Scanner userGuess = new Scanner(System.in);
		
		
		int numberOfTries = 5;
		
		boolean hasUserWon = false; // assuming the user has lost (initializing)
		
		
		while (numberOfTries > 0) {
			Integer userInputInteger = userGuess.nextInt();
			if (isWithinRange(userInputInteger) == true) {
				if (isGoodUserInput(theRandomNumber, userInputInteger, numberOfTries) == false) {
					numberOfTries = numberOfTries - 1;
				}
				else { //Win the game
					hasUserWon = true;
					break;
				}
			}
			else { //If the guess was not within range
				userInputInteger = userGuess.nextInt();
			}
		}
		
		if (numberOfTries == 0 && hasUserWon == false) {
			System.out.println("You lose!");
			System.out.println("The number to guess was " + theRandomNumber);
		}
			
		userGuess.close();
	}

	public static int creatingRandomNumber(int min, int max) {
	// This method created a random number
		Random randomNumber = new Random();

		return randomNumber.nextInt(max - min) + min;

	}

	public static boolean isGoodUserInput(int theRandomNumber, int userInput, int numberOfTries) {
	// This method validates for within range input and prompts to guess higher or lower
		if (userInput == theRandomNumber) {
			System.out.println("You win!");
			return true;
		}
		else if (numberOfTries == 1) {
			return false;
		} else if (userInput > theRandomNumber) {
			System.out.println("Please pick a lower number");
			return false;
		} else if (userInput < theRandomNumber) {
			System.out.println("Please pick a higher number");
			return false;
		}
		return false;
	}
	
	public static boolean isWithinRange(int userInput) {
	// This method validates for out of range input and prompts for input within range
		if (userInput <= 0) {
			System.out.println("Your guess is not between 1 and 100, please try again");
			return false;
		}
		else if (userInput > 100) {
			System.out.println("Your guess is not between 1 and 100, please try again");
			return false;
		}
		return true;
	}
}
