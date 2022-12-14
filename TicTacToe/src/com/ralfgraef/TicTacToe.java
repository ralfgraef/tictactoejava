package com.ralfgraef;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TicTacToe implements ActionListener{

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titel_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	public TicTacToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Ralfs Tic-Tac-Toe");
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free", Font.BOLD,65));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Ralfs Tic-Tac-Toe");
//		textfield.setBorder(new EmptyBorder(15,0,0,0));
		
		textfield.setOpaque(true);
		
		titel_panel.setLayout(new BorderLayout());
		titel_panel.setBounds(0,0,800,120);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		titel_panel.add(textfield);
		frame.add(titel_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}

	private void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (random.nextInt(2)==0) {
			player1_turn = true;	
			textfield.setText("X ist am Zug!");
		} else {
			player1_turn = false;	
			textfield.setText("O ist am Zug!");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < buttons.length; i++) {
			if (e.getSource()==buttons[i]) {
				if (player1_turn) {
					if (buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("O ist am Zug!");
						check();
					}
				} else {
					if (buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("X ist am Zug!");
						check();
					}
				}
			}
		}
		
	}

	private void check() {
		// check X win conditions
		if ((buttons[0].getText()=="X") && 
			(buttons[1].getText()=="X") &&
			(buttons[2].getText()=="X")) {
			playerWins("X",0,1,2);
		}
		
		if ((buttons[3].getText()=="X") && 
			(buttons[4].getText()=="X") &&
			(buttons[5].getText()=="X")) {
			playerWins("X",3,4,5);
		}
		
		if ((buttons[6].getText()=="X") && 
			(buttons[7].getText()=="X") &&
			(buttons[8].getText()=="X")) {
			playerWins("X",6,7,8);
		}
		
		if ((buttons[0].getText()=="X") && 
			(buttons[3].getText()=="X") &&
			(buttons[6].getText()=="X")) {
			playerWins("X",0,3,6);
			}
		
		if ((buttons[1].getText()=="X") && 
			(buttons[4].getText()=="X") &&
			(buttons[7].getText()=="X")) {
			playerWins("X",1,4,7);
			}
		
		if ((buttons[2].getText()=="X") && 
			(buttons[5].getText()=="X") &&
			(buttons[8].getText()=="X")) {
			playerWins("X",2,5,8);
			}
		
		if ((buttons[0].getText()=="X") && 
			(buttons[4].getText()=="X") &&
			(buttons[8].getText()=="X")) {
			playerWins("X",0,4,8);
			}
		
		if ((buttons[2].getText()=="X") && 
			(buttons[4].getText()=="X") &&
			(buttons[6].getText()=="X")) {
			playerWins("X",2,4,6);
			}
		
		// check O win conditions
		if ((buttons[0].getText()=="O") && 
			(buttons[1].getText()=="O") &&
			(buttons[2].getText()=="O")) {
			playerWins("O",0,1,2);
			}
				
		if ((buttons[3].getText()=="O") && 
			(buttons[4].getText()=="O") &&
			(buttons[5].getText()=="O")) {
			playerWins("O",3,4,5);
			}
				
		if ((buttons[6].getText()=="O") && 
			(buttons[7].getText()=="O") &&
			(buttons[8].getText()=="O")) {
			playerWins("O",6,7,8);
			}
				
		if ((buttons[0].getText()=="O") && 
			(buttons[3].getText()=="O") &&
			(buttons[6].getText()=="O")) {
			playerWins("O",0,3,6);
			}
				
		if ((buttons[1].getText()=="O") && 
			(buttons[4].getText()=="O") &&
			(buttons[7].getText()=="O")) {
			playerWins("O",1,4,7);
			}
				
		if ((buttons[2].getText()=="O") && 
			(buttons[5].getText()=="O") &&
			(buttons[8].getText()=="O")) {
			playerWins("O",2,5,8);
			}
				
		if ((buttons[0].getText()=="O") && 
			(buttons[4].getText()=="O") &&
			(buttons[8].getText()=="O")) {
			playerWins("O",0,4,8);
			}
				
		if ((buttons[2].getText()=="O") && 
			(buttons[4].getText()=="O") &&
			(buttons[6].getText()=="O")) {
			playerWins("O",2,4,6);
			}
	}
	
	private void playerWins(String player, int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false);
		}
		
		textfield.setText(player + " hat gewonnen!!!");
	
	}
	
	
	

//	private void xWins(int a, int b, int c) {
//		buttons[a].setBackground(Color.green);
//		buttons[b].setBackground(Color.green);
//		buttons[c].setBackground(Color.green);
//		
//		for (int i = 0; i < buttons.length; i++) {
//			buttons[i].setEnabled(false);
//		}
//		
//		textfield.setText("X hat gewonnen!!!");
//	}
	
	

}
