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

		Scanner userGuess = new Scanner(System.in);
		String userInput = userGuess.nextLine();
		Integer userInputInteger = Integer.parseInt(userInput);
		
		int numberOfTries = 4;
		
		while (numberOfTries > 0) {
			
			if (isWithinRange(userInputInteger) == true) {
				if (isGoodUserInput(theRandomNumber, userInputInteger) == false) {
					userInputInteger = userGuess.nextInt();
					numberOfTries = numberOfTries - 1;
				}
				else { //Win the game
					break;
				}
			}
			else { //If the guess was not within range
				userInputInteger = userGuess.nextInt();
			}
		}
		
		if (numberOfTries == 0) {
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

	public static boolean isGoodUserInput(int theRandomNumber, int userInput) {
	// This method validates for within range input and prompts to guess higher or lower
		if (userInput == theRandomNumber) {
			System.out.println("You win!");
			return true;
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
