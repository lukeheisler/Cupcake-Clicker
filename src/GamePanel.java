import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int HELP_STATE = 2;
	int currentState = MENU_STATE;
	
	Font titleFont;
	Font subtitleFont;
	
	String lang = "EN";
	
	Timer timer;
	Cupcake cupcake = new Cupcake(0);
	
	GamePanel() {
		timer = new Timer(1000/60, this);
		titleFont = new Font("Comic Sans MS", Font.BOLD, 48);
		subtitleFont = new Font("Comic Sans MS", Font.PLAIN, 24);
	}
	
	void startGame() {
		timer.start();
	}
		
	void updateMenuState() {
			
	}
		
	void updateGameState() {
		
	}
	
	void updateHelpState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		g.setColor(Color.MAGENTA);
		g.setFont(titleFont);
		int sw = g.getFontMetrics().stringWidth("Cupcake Clicker");
		g.drawString("Cupcake Clicker", CupcakeClicker.WIDTH/2-sw/2, 100);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Press ENTER to begin.");
		g.drawString("Press ENTER to begin.", 120, 350);
		sw = g.getFontMetrics().stringWidth("For help, press SPACE.");
		g.drawString("For help, press SPACE.", 115, 500);
	}
	
	void drawGameState(Graphics g) {
		/*
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		*/
	}
	
	void drawHelpState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		int sw = g.getFontMetrics().stringWidth("Help");
		g.drawString("Help", CupcakeClicker.WIDTH/2-sw/2, 100);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Welcome to Cupcake Clicker!");
		g.drawString("Welcome to Cupcake Clicker!", CupcakeClicker.WIDTH/2-sw/2, 300);
	}
	
	@Override
	public void paintComponent(Graphics g){
		switch(currentState) {
		case MENU_STATE:
			drawMenuState(g);
			break;
		case GAME_STATE:
			drawGameState(g);
			break;
		case HELP_STATE:
			drawHelpState(g);
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(currentState) {
		case MENU_STATE:
			updateMenuState();
			break;
		case GAME_STATE:
			updateGameState();
			break;
		case HELP_STATE:
			updateHelpState();
			break;
	}
	repaint();
		repaint();
	}

}
