/***************************************************
 * Farkle Assignment
 * Dice Enumerator
 * Dice.java
 * Created by Ethan Darling and Sabina Shrestha
 **************************************************/

package farkle;

import java.util.Random;

/**
 * Represents a Enumeration of six dice each with a position, value,
 * and held state. 
 * 
 * @author Ethan Darling and Sabina Shrestha
 *
 */
public enum Dice {
	DIE1(1, 0, false), DIE2(2, 0, false), DIE3(3, 0, false), DIE4(4, 0, false),
		DIE5(5, 0, false), DIE6(6, 0, false);
	
	private int position;
	private int value;
	private boolean held;
	private static Random rand = new Random();
	
	/**
	 * Initializes a new die with a position, value, and held state.
	 * @param position
	 * @param value
	 * @param held
	 */
	private Dice(int position, int value, boolean held) {
		this.position = position;
		this.value = value;
		this.held = held;
	}
	
	/**
	 * Gives the dice an initial value and held status.
	 */
	protected static void initialRoll() {
		for (Dice el : Dice.values()) {
			el.held = false;
			el.value = rand.nextInt(6) + 1;
		}
	}
	
	/**
	 * Checks each dice for whether it is being held. If it is being held, the
	 * die is ignored. If it is not being held, the die is given a new value.
	 */
	protected static void rollDie() {
		for (Dice el : Dice.values()) {
			if (el.held == false) {
				el.value = rand.nextInt(6) + 1;
			}
		}
	}
	
	/**
	 * Returns the position of a particular die (1-6) in the enumerator.
	 * 
	 * @return
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Returns the value of a particular die.
	 * Any die can have a random number between 1 and 6.
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the particular die value. Used for testing purposes.
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Returns the held state of the die. If the user has held it, it will
	 * not be rolled again.
	 * 
	 * @return
	 */
	public boolean isHeld() {
		return held;
	}

	/**
	 * Sets a particular die to be held based off of user input in Farkle.java.
	 * 
	 * @param held
	 */
	public void setHeld(boolean held) {
		this.held = held;
	}
}
