import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	//make IDs for different game states
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int SHOP_STATE = 2;
	final int HELP_STATE = 3;
	int currentState = MENU_STATE;
	
	public static BufferedImage chocolateCupcakeImg;
	
	//make font variables
	Font titleFont;
	Font subtitleFont;
	
	String lang = "EN"; //default language is English, others may be added later
	
	Timer timer;
	Cupcake cupcake = new Cupcake(0);
	
	GamePanel() {
		timer = new Timer(1000/60, this); //starts timer
		//set default fonts
		titleFont = new Font("Comic Sans MS", Font.BOLD, 48);
		subtitleFont = new Font("Comic Sans MS", Font.PLAIN, 24);
		
		try {
			chocolateCupcakeImg = ImageIO.read(this.getClass().getResourceAsStream("ChocolateCupcake.png")); //initializes cupcake image
		} 
		catch (IOException e) {
            e.printStackTrace();
		}
	}
	
	void startGame() {
		timer.start(); //starts timer
	}
		
	void updateMenuState() {
		//updates menuState
	}
		
	void updateGameState() {
		//updates gameState
	}
	
	void updateShopState() {
		//updates shopState
	}
	
	void updateHelpState() {
		//updates helpState
	}
	
	void drawMenuState(Graphics g) {
		//draws menuState
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		g.setColor(Color.MAGENTA);
		g.setFont(titleFont);
		int sw = g.getFontMetrics().stringWidth("Cupcake Clicker");
		g.drawString("Cupcake Clicker", CupcakeClicker.WIDTH/2-sw/2, 75);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Press ENTER to begin.");
		g.drawString("Press ENTER to begin.", CupcakeClicker.WIDTH/2-sw/2, 250);
		sw = g.getFontMetrics().stringWidth("For help, press SPACE.");
		g.drawString("For help, press SPACE.", CupcakeClicker.WIDTH/2-sw/2, 350);
	}
	
	void drawGameState(Graphics g) {
		//draws gameState
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		cupcake.draw(g); //draw cupcake
	}
	
	void drawShopState(Graphics g) {
		//draws shopState
	}
	
	void drawHelpState(Graphics g) {
		//draws helpState
		//TODO finish helpState
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		g.setColor(Color.MAGENTA);
		g.setFont(titleFont);
		int sw = g.getFontMetrics().stringWidth("How to Play");
		g.drawString("How to Play", CupcakeClicker.WIDTH/2-sw/2, 75);
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
		case SHOP_STATE:
			drawShopState(g);
			break;
		case HELP_STATE:
			drawHelpState(g);
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_ENTER) {
			//when enter is pressed
			if(currentState == MENU_STATE) {
				//if state is menuState
				currentState = GAME_STATE; //set state to gameState
			}
		}
		if(keyCode == KeyEvent.VK_SPACE) {
			//when space is pressed
			if(currentState == MENU_STATE) {
				//if state is menuState
				currentState = HELP_STATE; //set state to helpState
			}
		}
			
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
