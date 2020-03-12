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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	//make IDs for different game states
	final static int MENU_STATE = 0;
	final static int GAME_STATE = 1;
	final static int SHOP_STATE = 2;
	final static int HELP_STATE = 3;
	static int currentState = MENU_STATE;
	
	public static BufferedImage chocolateCupcakeImg;
	
	//make font variables
	Font titleFont;
	Font subtitleFont;
	Font infoFont;
	
	String lang = "EN"; //default language is English, others may be added later
	
	Timer timer;
	Cupcake cupcake = new Cupcake(0);
	
	private int cupcakeCount;
	boolean keyDown = false;
	int shopScroll = 0;
	
	GamePanel() {
		timer = new Timer(1000/60, this); //starts timer
		//set default fonts
		titleFont = new Font("Helvetica", Font.BOLD, 48);
		subtitleFont = new Font("Helvetica", Font.PLAIN, 24);
		infoFont = new Font("Helvetica", Font.PLAIN, 16);
		
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
		g.drawString("Cupcake Clicker", CupcakeClicker.WIDTH/2-sw/2, 100);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Press ENTER to begin.");
		g.drawString("Press ENTER to begin.", CupcakeClicker.WIDTH/2-sw/2, 300);
		sw = g.getFontMetrics().stringWidth("For help, press SPACE.");
		g.drawString("For help, press SPACE.", CupcakeClicker.WIDTH/2-sw/2, 400);
	}
	
	void drawGameState(Graphics g) {
		//draws gameState
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		cupcake.draw(g); //draw cupcake
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		g.drawString("Cupcakes: " + cupcakeCount, 25, 50);
		int sw = g.getFontMetrics().stringWidth("Press ENTER to go to the shop!");
		g.drawString("Press ENTER to go to the shop!", CupcakeClicker.WIDTH/2-sw/2, 700);
	}
	
	void drawShopState(Graphics g) {
		//draws shopState
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		g.setColor(Color.MAGENTA);
		g.setFont(titleFont);
		int sw = g.getFontMetrics().stringWidth("Shop");
		g.drawString("Shop", CupcakeClicker.WIDTH/2-sw/2, 75);
		
		//Faulty Cupcake Machine (1)
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Faulty Cupcake Machine");
		g.drawString("Faulty Cupcake Machine", CupcakeClicker.WIDTH/2-sw/2, 150);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 100 cupcakes, yields 10 cupcakes/min");
		g.drawString("Costs 100 cupcakes, yields 10 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 175);
		sw = g.getFontMetrics().stringWidth("You own #");
		g.drawString("You own #", CupcakeClicker.WIDTH/2-sw/2, 200);
		
		//Underpaid Worker (2)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Underpaid Worker");
		g.drawString("Underpaid Worker", CupcakeClicker.WIDTH/2-sw/2, 225);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 250 cupcakes, yields 30 cupcakes/min");
		g.drawString("Costs 250 cupcakes, yields 30 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 250);
		sw = g.getFontMetrics().stringWidth("You own #");
		g.drawString("You own #", CupcakeClicker.WIDTH/2-sw/2, 275);
		
		//Standard Worker (3)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Standard Worker");
		g.drawString("Standard Worker", CupcakeClicker.WIDTH/2-sw/2, 300);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 500 cupcakes, yields 75 cupcakes/min");
		g.drawString("Costs 500 cupcakes, yields 75 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 325);
		sw = g.getFontMetrics().stringWidth("You own #");
		g.drawString("You own #", CupcakeClicker.WIDTH/2-sw/2, 350);
		
		//Standard Cupcake Machine (4)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Standard Cupcake Machine");
		g.drawString("Standard Cupcake Machine", CupcakeClicker.WIDTH/2-sw/2, 375);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 1000 cupcakes, yields 200 cupcakes/min");
		g.drawString("Costs 1000 cupcakes, yields 200 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 400);
		sw = g.getFontMetrics().stringWidth("You own #");
		g.drawString("You own #", CupcakeClicker.WIDTH/2-sw/2, 425);
		
		//Speedy Worker (5)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Speedy Worker");
		g.drawString("Speedy Worker", CupcakeClicker.WIDTH/2-sw/2, 450);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 1500 cupcakes, yields 400 cupcakes/min");
		g.drawString("Costs 1500 cupcakes, yields 400 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 475);
		sw = g.getFontMetrics().stringWidth("You own #");
		g.drawString("You own #", CupcakeClicker.WIDTH/2-sw/2, 500);
		
		//Deluxe Cupcake Machine (6)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Deluxe Cupcake Machine");
		g.drawString("Deluxe Cupcake Machine", CupcakeClicker.WIDTH/2-sw/2, 525);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 2500 cupcakes, yields 800 cupcakes/min");
		g.drawString("Costs 2500 cupcakes, yields 800 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 550);
		sw = g.getFontMetrics().stringWidth("You own #");
		g.drawString("You own #", CupcakeClicker.WIDTH/2-sw/2, 575);
		
		g.setColor(Color.RED);
		g.setFont(subtitleFont);
		switch(shopScroll) {
		case 1:
			g.drawString(">", 25, 150);
			break;
		case 2:
			g.drawString(">", 25, 225);
			break;
		case 3:
			g.drawString(">", 25, 300);
			break;
		case 4:
			g.drawString(">", 25, 375);
			break;
		case 5:
			g.drawString(">", 25, 450);
			break;
		case 6:
			g.drawString(">", 25, 525);
		}
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
		
		if(keyDown == false) {
			keyDown = true;
			if(keyCode == KeyEvent.VK_ENTER) {
				//when enter is pressed
				if(currentState == MENU_STATE) {
					//if state is menuState
					currentState = GAME_STATE; //set state to gameState
				}
				else if(currentState == GAME_STATE) {
					//if state is gameState
					currentState = SHOP_STATE; //set state to shopState
				}
			}
			else if(keyCode == KeyEvent.VK_SPACE) {
				//when space is pressed
				if(currentState == MENU_STATE) {
					//if state is menuState
					currentState = HELP_STATE; //set state to helpState
				}
				else if(currentState == GAME_STATE) {
					cupcakeCount++;
				}
			}
			else if(keyCode == KeyEvent.VK_DOWN) {
				if(currentState == SHOP_STATE) {
					shopScroll++;
				}
			}
			else if(keyCode == KeyEvent.VK_UP) {
				if(currentState == SHOP_STATE) {
					shopScroll--;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		//to limit holding down a key
		keyDown = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
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
		case SHOP_STATE:
			updateShopState();
			break;
		case HELP_STATE:
			updateHelpState();
			break;
	}
	repaint();
		repaint();
	}

}
