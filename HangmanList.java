import java.awt.EventQueue;
import java.util.*;

public class HangmanList {
	private static String[] secretWords = {"hippopotamus","canyon","router","dank","violet","horses","potato","keyboard","monitor","password","assignment" }; //list of possible words to guess
	private String secret; //word player is trying to guess
	private StringBuilder hashedWord; //'secret' in hashed form
	private Random random; //generate a random number
	private int guesses; //amount of guesses left
	private boolean gameOver; //true if you win, false if you lose
	private int x;
	
	
	/**
	 * Constructor to create new HangmanList
	 */
	public HangmanList() {
		pickWord();
		createHash(secret);
		guesses = 6;
	}
	
	/**
	 *  Checks if selected letter is in 'secret' and updates 'hashedWord' if it is
	 */
	public void checkLetter(char c) {
		if(secret.indexOf(c) < 0) {
			guesses--; //character was not in 'secret'
		} else {
			for(int i=0; i<secret.length(); i++) {
				if(secret.charAt(i)==c) {
					hashedWord.setCharAt(i,c);
				}
			}
		}
		checkGame();
	}
	
	/**
	 *  Creates a hashed version of 'secret'
	 */
	public void createHash(String s) {
		hashedWord = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			hashedWord.append("*");
		}
	}
	
	/**
	 *  Picks a word from 'secretWords'
	 */
	public void pickWord() {
		random = new Random();
		x = random.nextInt(secretWords.length);
		secret = secretWords[x];
	}
	
	/**
	 *  Checks if game is complete
	 */
	public void checkGame() {
		if(secret.equals(hashedWord.toString())) {
			gameOver = true;
		} else if(guesses==0) {
			gameOver = false;
		}
	}
	
	/**
	 *  Setters and Getters
	 */
	public String getSecret() {
		return secret;
	}
	
	public int getGuesses() {
		return guesses;
	}
	
	public StringBuilder getHashed() {
		return hashedWord;
	}
	
	public boolean getStatus() {
		return gameOver;
	}
	
}
