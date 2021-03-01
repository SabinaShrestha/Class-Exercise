/***************************************************
 * Farkle Assignment
 * Farkle GUI
 * Farkle.java
 * Created by Ethan Darling and Sabina Shrestha
 **************************************************/

package farkle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

/**
 * Represents the basic game loop for the farkle game.
 * Implements rolling and holding and is used as a test client.
 * @author Ethan Darling and Sabina Shrestha
 *
 */
public class Farkle extends JFrame{
	
	/**
	 * Serializes the JFrame
	 */
	private static final long serialVersionUID = 6855101460786226298L;
	
	private JPanel contentPane;
	private final JPanel panelRules = new JPanel();
	
	private static int score = 0;
	private static int playerScore = 0;
	private static int compScore = 0;
	private static boolean playerTurn = true;
	
	private static Color turquoise = new Color(72, 209, 204);

	private static JLabel lblPlayerScore = new JLabel("Player's Score:");
	private static JLabel lblComputerScore = new JLabel("Computer's Score:");
	private static JLabel lblFarkle = new JLabel("Farkle");

	private static JButton btnDieOne = new JButton("DieOne");
	private static JButton btnDieTwo = new JButton("DieTwo");
	private static JButton btnDieThree = new JButton("DieThree");
	private static JButton btnDieFour = new JButton("DieFour");
	private static JButton btnDieFive = new JButton("DieFive");
	private static JButton btnDieSix = new JButton("DieSix");
	private static JButton btnRoll = new JButton("Roll");
	private static JButton btnScore = new JButton("Score");
	
	private final JTextPane textPaneLeft = new JTextPane();
	private final JTextPane textPaneRight = new JTextPane();

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farkle frame = new Farkle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try (Scanner input = new Scanner(System.in)) {
			Dice.initialRoll(); // Gives the dice initial values.
			changeDiceText();
			calculateComputerScore();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Farkle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = createContentPane();
		
		contentPane.add(mainPanel, BorderLayout.NORTH);
	}
	
	//Checks for winner and disables the score and roll buttons.
	private static void winner() {
		if (playerScore >= 10000) {
			lblPlayerScore.setText("Player's Score: " + "Winner!!!");
			lblComputerScore.setText("Computer's Score: " + "No Win");
			btnRoll.setEnabled(false);
			btnScore.setEnabled(false);
		}
		else if (compScore >= 10000) {
			lblComputerScore.setText("Computer's Score: " + "Winner!!!");
			lblPlayerScore.setText("Computer's Score: " + "No Win");
			btnRoll.setEnabled(false);
			btnScore.setEnabled(false);
		}
	}

	/**
	 * Calculates the computer's score, sets the player's turn to false, rolls dice,
	 * and updates the computer's score text.
	 */
	
	private static void calculateComputerScore() {
		if (playerTurn == false) {
			score = 0;
			Dice.initialRoll();

			compScore += calculateScore(score);
			lblComputerScore.setText("Computer's Score: " + Integer.toString(compScore));
		}
	}

	/**
	 * Changes each dice buttons text to the appropriate value.
	 */
	private static void changeDiceText() {
		btnDieOne.setText(Integer.toString(Dice.DIE1.getValue()));
		btnDieTwo.setText(Integer.toString(Dice.DIE2.getValue()));
		btnDieThree.setText(Integer.toString(Dice.DIE3.getValue()));
		btnDieFour.setText(Integer.toString(Dice.DIE4.getValue()));
		btnDieFive.setText(Integer.toString(Dice.DIE5.getValue()));
		btnDieSix.setText(Integer.toString(Dice.DIE6.getValue()));
	}
	
	/**
	 * Calculates the score of the dice that the player or computer has.
	 */
	private static int calculateScore(int tempScore) {
		score =  0;
		tempScore = 0;
		
		// Counters for the number of values in a roll.
		int countOne = 0;
		int countTwo = 0;
		int countThree = 0;
		int countFour = 0;
		int countFive = 0;
		int countSix = 0;
		
		// Iterates through each roll to count the values.
		for (Dice el : Dice.values()) {
			switch (el.getValue()) {
				case 1: countOne++;
					break;
				case 2: countTwo++;
					break;
				case 3: countThree++;
					break;
				case 4: countFour++;
					break;
				case 5: countFive++;
					break;
				case 6: countSix++;
					break;
			}
		}
		
		int[] countArray = {countOne, countTwo, countThree, countFour, countFive, countSix};
		
		// Checks for Ones and Fives
		for (Dice el : Dice.values()) {
			if (el.getValue() == 1 && countOne == 1) {
				tempScore += 100;
			}
			 if (el.getValue() == 5 && countFive == 1) {
				tempScore =+ 50;
			 }
		}
		
		// Checks for 2 triples.
		int countTriples = 0;
				for (int el : countArray) {	
					if (el == 3) {
						countTriples++;
					}
				}
				if (countTriples == 2) {
					tempScore += 2500;
				}
		
		// Checks for triples.
		for (int i = 0; i < 6; i++) {
			if (countTriples != 2) {
				if (countArray[i] == 3 && i == 0) {
					tempScore += 300;
				}
				if (countArray[i] == 3 && i == 1) {
					tempScore += 200;
				}
				if (countArray[i] == 3 && i == 2) {
					tempScore += 300;
				}
				if (countArray[i] == 3 && i == 3) {
					tempScore += 400;
				}
				if (countArray[i] == 3 && i == 4) {
					tempScore += 500;
				}
				if (countArray[i] == 3 && i == 5) {
					tempScore += 600;
				}
			}
		}
		
		// Checks for four of any number and a full house.
		for (int el : countArray) {
			if (el == 4) {
				tempScore += 1000;
			}
			if (el == 2) {
				tempScore += 500;
			}
		}
		
		// Checks for five of any number.
		for (int el : countArray) {
			if (el == 5) {
				tempScore += 2000;
			}
		}
		
		// Checks for six of any number.
		for (int el : countArray) {
			if (el == 6) {
				tempScore += 3000;
			}
		}
		
		// Checks for a straight.
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		for (Dice el : Dice.values()) {
			switch (el.getValue()) {
				case 1 : one++;
				case 2 : two++;
				case 3 : three++;
				case 4 : four++;
				case 5 : five++;
				case 6 : six++;
			}
		}
		if (one == 1 && two == 2 && three == 3 && four == 4 && five == 5 && six == 6) {
			tempScore += (1500); 
		}
		
		// Checks for three pairs.
		int countPairs = 0;
		for (int el : countArray) {
			if (el == 2) {
				countPairs++;
			}
		}
		if (countPairs == 3) {
			tempScore += 1500;
		}
		
		return tempScore;
	}

	/**
	 * Contains the player's score, computer's score, rules, and the title.
	 * @return
	 */
	private JPanel createContentPane() {
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(46, 139, 87));
		GridBagLayout gbl_panelTitle = new GridBagLayout();
		gbl_panelTitle.columnWidths = new int[]{476, 0};
		gbl_panelTitle.rowHeights = new int[]{43, 145, 0};
		gbl_panelTitle.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelTitle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelTitle.setLayout(gbl_panelTitle);
		lblFarkle.setPreferredSize(new Dimension(28, 50));
		lblFarkle.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFarkle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblFarkle = new GridBagConstraints();
		gbc_lblFarkle.fill = GridBagConstraints.BOTH;
		gbc_lblFarkle.insets = new Insets(0, 0, 5, 0);
		gbc_lblFarkle.gridx = 0;
		gbc_lblFarkle.gridy = 0;
		panelTitle.add(lblFarkle, gbc_lblFarkle);
		panelRules.setBackground(new Color(46, 139, 87));
		GridBagConstraints gbc_panelRules = new GridBagConstraints();
		gbc_panelRules.fill = GridBagConstraints.BOTH;
		gbc_panelRules.gridx = 0;
		gbc_panelRules.gridy = 1;
		panelTitle.add(panelRules, gbc_panelRules);
		panelRules.setLayout(new GridLayout(0, 2, 0, 0));
		textPaneLeft.setFont(new Font("Arial", Font.BOLD, 14));
		textPaneLeft.setBackground(new Color(46, 139, 87));
		textPaneLeft.setText("                Single 1 = 100\r\n                Single 5 = 50"
				+ "\r\n                Three 1's = 300"
				+ "\r\n                Three 2's = 200\r\n                Three 3's = 300"
				+ "\r\n                Three 4's = 400"
				+ "\r\n                Three 5's = 500\r\n                Three 6's = 600");
		
		panelRules.add(textPaneLeft);
		textPaneRight.setFont(new Font("Arial", Font.BOLD, 14));
		textPaneRight.setBackground(new Color(46, 139, 87));
		textPaneRight.setText("        Four of any # = 1,000\r\n        Five of any # = 2,000"
				+ "\r\n        Six of any # = 3,000\r\n        Straight = 1,500\r\n        Three Pairs = 1,500"
				+ "\r\n        Full House = 1,500\r\n        Two Triplets = 2,500");
		
		panelRules.add(textPaneRight);
		
		JPanel panelDice = createDicePanel();
		
		contentPane.add(panelDice, BorderLayout.CENTER);
		
		JPanel panelScore = new JPanel();
		panelScore.setPreferredSize(new Dimension(10, 50));
		panelScore.setSize(new Dimension(0, 100));
		panelScore.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelScore.setBackground(new Color(106, 90, 205));
		contentPane.add(panelScore, BorderLayout.SOUTH);
		panelScore.setLayout(new GridLayout(1, 0, 0, 0));
		lblPlayerScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblPlayerScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerScore.setText("Player's Score: " + Integer.toString(playerScore));
		panelScore.add(lblPlayerScore);
		lblComputerScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblComputerScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComputerScore.setText("Computer's Score: " + Integer.toString(compScore));
		panelScore.add(lblComputerScore);
		return panelTitle;
	}

	/**
	 * Contains each of the dice, roll, and score buttons along with instructional text.
	 * @return
	 */
	private JPanel createDicePanel() {
		JPanel panelDice = new JPanel();
		panelDice.setBackground(new Color(46, 139, 87));
		panelDice.setPreferredSize(new Dimension(79, 79));
		panelDice.setMinimumSize(new Dimension(79, 79));
		
		GridBagLayout gbl_panelDice = new GridBagLayout();
		gbl_panelDice.columnWidths = new int[]{79, 79, 79, 79, 79, 79, 0};
		gbl_panelDice.rowHeights = new int[] {79, 79, 0};
		gbl_panelDice.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDice.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelDice.setLayout(gbl_panelDice);
		
		/*
		 * Roll Button
		 */
		GridBagConstraints gbc_btnRoll = new GridBagConstraints();
		gbc_btnRoll.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRoll.insets = new Insets(0, 0, 5, 5);
		gbc_btnRoll.gridx = 0;
		gbc_btnRoll.gridy = 0;
		btnRoll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRoll.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRoll.setFont(new Font("Arial", Font.BOLD, 14));
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dice.rollDie();
				changeDiceText();
			}
		});
		btnRoll.setBackground(new Color(95, 158, 160));
		btnRoll.setMinimumSize(new Dimension(79, 79));
		btnRoll.setPreferredSize(new Dimension(70, 79));
		panelDice.add(btnRoll, gbc_btnRoll);
		
		/*
		 * Score Button
		 */
		GridBagConstraints gbc_btnScore = new GridBagConstraints();
		gbc_btnScore.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnScore.insets = new Insets(0, 0, 5, 0);
		gbc_btnScore.gridx = 5;
		gbc_btnScore.gridy = 0;
		btnScore.setFont(new Font("Arial", Font.BOLD, 14));
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerTurn = false;
				playerScore += calculateScore(score);
				lblPlayerScore.setText("Player's Score: " + Integer.toString(playerScore));
				calculateComputerScore();
				winner();
				
				for (Dice el : Dice.values()) {
					el.setHeld(false);
				}
				
				btnDieOne.setBackground(turquoise);
				btnDieTwo.setBackground(turquoise);
				btnDieThree.setBackground(turquoise);
				btnDieFour.setBackground(turquoise);
				btnDieFive.setBackground(turquoise);
				btnDieSix.setBackground(turquoise);
				
				Dice.rollDie();
				changeDiceText();
			}
		});
		btnScore.setBackground(new Color(95, 158, 160));
		btnScore.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnScore.setMinimumSize(new Dimension(79, 79));
		btnScore.setPreferredSize(new Dimension(70, 79));
		panelDice.add(btnScore, gbc_btnScore);
		
		GridBagConstraints gbc_btnDieOne = new GridBagConstraints();
		gbc_btnDieOne.fill = GridBagConstraints.BOTH;
		gbc_btnDieOne.insets = new Insets(0, 0, 0, 5);
		gbc_btnDieOne.gridx = 0;
		gbc_btnDieOne.gridy = 1;

		GridBagConstraints gbc_btnDieTwo = new GridBagConstraints();
		gbc_btnDieTwo.fill = GridBagConstraints.BOTH;
		gbc_btnDieTwo.insets = new Insets(0, 0, 0, 5);
		gbc_btnDieTwo.gridx = 1;
		gbc_btnDieTwo.gridy = 1;

		GridBagConstraints gbc_btnDieThree = new GridBagConstraints();
		gbc_btnDieThree.fill = GridBagConstraints.BOTH;
		gbc_btnDieThree.insets = new Insets(0, 0, 0, 5);
		gbc_btnDieThree.gridx = 2;
		gbc_btnDieThree.gridy = 1;
		

		GridBagConstraints gbc_btnDieFour = new GridBagConstraints();
		gbc_btnDieFour.fill = GridBagConstraints.BOTH;
		gbc_btnDieFour.insets = new Insets(0, 0, 0, 5);
		gbc_btnDieFour.gridx = 3;
		gbc_btnDieFour.gridy = 1;
		
		GridBagConstraints gbc_btnDieFive = new GridBagConstraints();
		gbc_btnDieFive.fill = GridBagConstraints.BOTH;
		gbc_btnDieFive.insets = new Insets(0, 0, 0, 5);
		gbc_btnDieFive.gridx = 4;
		gbc_btnDieFive.gridy = 1;
		
		GridBagConstraints gbc_btnDieSix = new GridBagConstraints();
		gbc_btnDieSix.fill = GridBagConstraints.BOTH;
		gbc_btnDieSix.gridx = 5;
		gbc_btnDieSix.gridy = 1;
		
		createDiceListeners();
		
		btnDieOne.setPreferredSize(new Dimension(70, 21));
		btnDieOne.setFont(new Font("Arial", Font.BOLD, 16));
		panelDice.add(btnDieOne, gbc_btnDieOne);
		btnDieTwo.setPreferredSize(new Dimension(70, 21));
		btnDieTwo.setFont(new Font("Arial", Font.BOLD, 16));
		panelDice.add(btnDieTwo, gbc_btnDieTwo);
		btnDieThree.setPreferredSize(new Dimension(70, 21));
		btnDieThree.setFont(new Font("Arial", Font.BOLD, 16));
		panelDice.add(btnDieThree, gbc_btnDieThree);
		btnDieFour.setPreferredSize(new Dimension(70, 21));
		btnDieFour.setFont(new Font("Arial", Font.BOLD, 16));
		panelDice.add(btnDieFour, gbc_btnDieFour);
		btnDieFive.setPreferredSize(new Dimension(70, 21));
		btnDieFive.setFont(new Font("Arial", Font.BOLD, 16));
		panelDice.add(btnDieFive, gbc_btnDieFive);
		btnDieSix.setPreferredSize(new Dimension(70, 21));
		btnDieSix.setFont(new Font("Arial", Font.BOLD, 16));
		panelDice.add(btnDieSix, gbc_btnDieSix);
		
		return panelDice;
	}

	/**
	 * Creates action listeners for each die.
	 * Placed in new method for easy access.
	 */
	private void createDiceListeners() {
		btnDieOne.setBackground(new Color(72, 209, 204));
		btnDieOne.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDieOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dice.DIE1.setHeld(true);
				btnDieOne.setBackground(Color.green);
			}
		});

		btnDieTwo.setBackground(new Color(72, 209, 204));
		btnDieTwo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDieTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dice.DIE2.setHeld(true);
				btnDieTwo.setBackground(Color.green);
			}
		});

		btnDieThree.setBackground(new Color(72, 209, 204));
		btnDieThree.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDieThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dice.DIE3.setHeld(true);
				btnDieThree.setBackground(Color.green);
			}
		});

		btnDieFour.setBackground(new Color(72, 209, 204));
		btnDieFour.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDieFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dice.DIE4.setHeld(true);
				btnDieFour.setBackground(Color.green);
			}
		});

		btnDieFive.setBackground(new Color(72, 209, 204));
		btnDieFive.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDieFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dice.DIE5.setHeld(true);
				btnDieFive.setBackground(Color.green);
			}
		});

		btnDieSix.setBackground(new Color(72, 209, 204));
		btnDieSix.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDieSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dice.DIE6.setHeld(true);
				btnDieSix.setBackground(Color.green);
			}
		});
	}
}
