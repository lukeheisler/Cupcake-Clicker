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
	
	private float cupcakeCount;
	boolean keyDown = false;
	int shopScroll = 0;
	int confirmState = 0;
	
	//amt of products owned
	private int item1Owned = 0;
	private int item2Owned = 0;
	private int item3Owned = 0;
	private int item4Owned = 0;
	private int item5Owned = 0;
	private int item6Owned = 0;
	private int item7Owned = 0;
	
	GamePanel() {
		timer = new Timer(1000/60, this); //initialize timer
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
		while(true) {
			//gives cupcakes from shop every second
			for(int i = 0; i< 10; i++) {
			    try {
			        Thread.sleep(1000);
			    }
			    catch(InterruptedException ie) {
			    	
			    }
			    cupcakeCount += (item1Owned*10 + item2Owned*50 + item3Owned*150 + item4Owned*500 + item5Owned*1500 + item6Owned*10000 + item7Owned*25000) / 60.;
			}
		}
	}
		
	void updateMenuState() {
		
	}
		
	void updateGameState() {
		
	}
	
	void updateShopState() {
		
	}
	
	void updateHelpState() {
		
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
		g.drawString("Cupcakes: " + (int) cupcakeCount, 25, 50);
		int sw = g.getFontMetrics().stringWidth("Press SPACE to get a cupcake.");
		g.drawString("Press SPACE to get a cupcake.", CupcakeClicker.WIDTH/2-sw/2, 725);
		sw = g.getFontMetrics().stringWidth("Press ENTER to go to the shop.");
		g.drawString("Press ENTER to go to the shop.", CupcakeClicker.WIDTH/2-sw/2, 750);
		
	}
	
	void drawShopState(Graphics g) {
		//draws shopState
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		
		g.setColor(Color.MAGENTA);
		g.setFont(titleFont);
		int sw = g.getFontMetrics().stringWidth("Shop");
		g.drawString("Shop", CupcakeClicker.WIDTH/2-sw/2, 75);
		
		g.setColor(Color.ORANGE);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("You have " + (int) cupcakeCount + " cupcakes.");
		g.drawString("You have " + (int) cupcakeCount + " cupcakes.", CupcakeClicker.WIDTH/2-sw/2, 110);
		
		//Faulty Cupcake Machine (1)
		g.setColor(Color.MAGENTA);
		sw = g.getFontMetrics().stringWidth("Faulty Cupcake Machine");
		g.drawString("Faulty Cupcake Machine", CupcakeClicker.WIDTH/2-sw/2, 150);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 100 cupcakes, yields 10 cupcakes/min");
		g.drawString("Costs 100 cupcakes, yields 10 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 175);
		sw = g.getFontMetrics().stringWidth("You own " + item1Owned);
		g.drawString("You own " + item1Owned, CupcakeClicker.WIDTH/2-sw/2, 200);
		
		//Underpaid Worker (2)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Underpaid Worker");
		g.drawString("Underpaid Worker", CupcakeClicker.WIDTH/2-sw/2, 225);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 300 cupcakes, yields 50 cupcakes/min");
		g.drawString("Costs 300 cupcakes, yields 50 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 250);
		sw = g.getFontMetrics().stringWidth("You own " + item2Owned);
		g.drawString("You own " + item2Owned, CupcakeClicker.WIDTH/2-sw/2, 275);
		
		//Standard Worker (3)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Standard Worker");
		g.drawString("Standard Worker", CupcakeClicker.WIDTH/2-sw/2, 300);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 1000 cupcakes, yields 150 cupcakes/min");
		g.drawString("Costs 1000 cupcakes, yields 150 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 325);
		sw = g.getFontMetrics().stringWidth("You own " + item3Owned);
		g.drawString("You own " + item3Owned, CupcakeClicker.WIDTH/2-sw/2, 350);
		
		//Standard Cupcake Machine (4)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Standard Cupcake Machine");
		g.drawString("Standard Cupcake Machine", CupcakeClicker.WIDTH/2-sw/2, 375);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 3000 cupcakes, yields 500 cupcakes/min");
		g.drawString("Costs 3000 cupcakes, yields 500 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 400);
		sw = g.getFontMetrics().stringWidth("You own " + item4Owned);
		g.drawString("You own " + item4Owned, CupcakeClicker.WIDTH/2-sw/2, 425);
		
		//Speedy Worker (5)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Speedy Worker");
		g.drawString("Speedy Worker", CupcakeClicker.WIDTH/2-sw/2, 450);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 10 000 cupcakes, yields 1500 cupcakes/min");
		g.drawString("Costs 10 000 cupcakes, yields 1500 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 475);
		sw = g.getFontMetrics().stringWidth("You own " + item5Owned);
		g.drawString("You own " + item5Owned, CupcakeClicker.WIDTH/2-sw/2, 500);
		
		//Deluxe Cupcake Machine (6)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Deluxe Cupcake Machine");
		g.drawString("Deluxe Cupcake Machine", CupcakeClicker.WIDTH/2-sw/2, 525);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 50 000 cupcakes, yields 10 000 cupcakes/min");
		g.drawString("Costs 50 000 cupcakes, yields 10 000 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 550);
		sw = g.getFontMetrics().stringWidth("You own " + item6Owned);
		g.drawString("You own " + item6Owned, CupcakeClicker.WIDTH/2-sw/2, 575);
		
		//Nuclear Cupcake Reactor (7)
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Nuclear Cupcake Reactor");
		g.drawString("Nuclear Cupcake Reactor", CupcakeClicker.WIDTH/2-sw/2, 600);
		g.setColor(Color.CYAN);
		g.setFont(infoFont);
		sw = g.getFontMetrics().stringWidth("Costs 100 000 cupcakes, yields 25 000 cupcakes/min");
		g.drawString("Costs 100 000 cupcakes, yields 25 0000 cupcakes/min", CupcakeClicker.WIDTH/2-sw/2, 625);
		sw = g.getFontMetrics().stringWidth("You own " + item7Owned);
		g.drawString("You own " + item7Owned, CupcakeClicker.WIDTH/2-sw/2, 650);
		
		//Scroll arrow
		g.setFont(subtitleFont);
		switch(confirmState) {
		case 0:
			g.setColor(Color.RED);
			sw = g.getFontMetrics().stringWidth("Press ENTER to buy one of the selected item.");
			g.drawString("Press ENTER to buy one of the selected item.", CupcakeClicker.WIDTH/2-sw/2, 725);
			sw = g.getFontMetrics().stringWidth("Press BACKSPACE to leave the shop.");
			g.setColor(Color.ORANGE);
			g.drawString("Press BACKSPACE to leave the shop.", CupcakeClicker.WIDTH/2-sw/2, 750);
			break;
		case 1:
			g.setColor(Color.YELLOW);
			sw = g.getFontMetrics().stringWidth("Press ENTER to confirm your purchase.");
			g.drawString("Press ENTER to confirm your purchase.", CupcakeClicker.WIDTH/2-sw/2, 725);
			g.setColor(Color.ORANGE);
			sw = g.getFontMetrics().stringWidth("Press BACKSPACE to cancel your purchace.");
			g.drawString("Press BACKSPACE to cancel your purchace.", CupcakeClicker.WIDTH/2-sw/2, 750);
			g.setColor(Color.RED);
			break;
		case 2:
			g.setColor(Color.GREEN);
			sw = g.getFontMetrics().stringWidth("Purchace successful!");
			g.drawString("Purchace successful!", CupcakeClicker.WIDTH/2-sw/2, 725);
			g.setColor(Color.RED);
			sw = g.getFontMetrics().stringWidth("Press ENTER to buy more items.");
			g.drawString("Press ENTER to buy more items.", CupcakeClicker.WIDTH/2-sw/2, 750);
			sw = g.getFontMetrics().stringWidth("Press BACKSPACE to leave the shop.");
			g.drawString("Press BACKSPACE to leave the shop.", CupcakeClicker.WIDTH/2-sw/2, 775);
			break;
		case 3:
			g.setColor(Color.RED);
			sw = g.getFontMetrics().stringWidth("You don't have enough cupcakes!");
			g.drawString("You don't have enough cupcakes!", CupcakeClicker.WIDTH/2-sw/2, 725);
			g.setColor(Color.ORANGE);
			sw = g.getFontMetrics().stringWidth("Press ENTER to continue.");
			g.drawString("Press ENTER to continue.", CupcakeClicker.WIDTH/2-sw/2, 750);
			break;
		}
		switch(shopScroll) {
		case -1:
			shopScroll = 7;
			break;
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
			break;
		case 7:
			g.drawString(">", 25, 600);
			break;
		case 8:
			shopScroll = 1;
			break;
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
		g.drawString("Welcome to Cupcake Clicker!", CupcakeClicker.WIDTH/2-sw/2, 150);
		g.setColor(Color.WHITE);
		g.setFont(infoFont);
		g.drawString("-The aim of the game is to press SPACE to get cupcakes.", 10, 200);
		g.drawString("-You can use your cupcakes as currency in the shop to buy products", 10, 225);
		g.drawString("that will earn you more cupcakes.", 10, 250);
		g.drawString("-There is no explicit goal to this game, just earn as many cupcakes", 10, 275);
		g.drawString("as you can!", 10, 300);
		g.setColor(Color.MAGENTA);
		g.setFont(subtitleFont);
		sw = g.getFontMetrics().stringWidth("Press BACKSPACE to leave this screen.");
		g.drawString("Press BACKSPACE to leave this screen.", CupcakeClicker.WIDTH/2-sw/2, 700);
	}
	
	void buyItem(int item) {
		switch(item) {
		case 1:
			if(cupcakeCount >= 100) {
				item1Owned++;
				cupcakeCount -= 100;
				confirmState++;
			}
			else {
				confirmState += 2;
			}
			break;
		case 2:
			if(cupcakeCount >= 300) {
				item2Owned++;
				cupcakeCount -= 300;
				confirmState++;
			}
			else {
				confirmState += 2;
			}
			break;
		case 3:
			if(cupcakeCount >= 1000) {
				item3Owned++;
				cupcakeCount -= 1000;
				confirmState++;
			}
			else {
				confirmState += 2;
			}
			break;
		case 4:
			if(cupcakeCount >= 3000) {
				item4Owned++;
				cupcakeCount -= 3000;
				confirmState++;
			}
			else {
				confirmState += 2;
			}
			break;
		case 5:
			if(cupcakeCount >= 10000) {
				item5Owned++;
				cupcakeCount -= 10000;
				confirmState++;
			}
			else {
				confirmState += 2;
			}
			break;
		case 6:
			if(cupcakeCount >= 50000) {
				item6Owned++;
				cupcakeCount -= 50000;
				confirmState++;
			}
			else {
				confirmState += 2;
			}
			break;
		case 7:
			if(cupcakeCount >= 100000) {
				item7Owned++;
				cupcakeCount -= 100000;
				confirmState++;
			}
			else {
				confirmState += 2;
			}
			break;
		}
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
				else if(currentState == SHOP_STATE) {
					//if state is shopState
					switch(confirmState) {
					case 0:
						confirmState++;
						break;
					case 1:
						buyItem(shopScroll);
						break;
					case 2:
						confirmState = 0;
						break;
					case 3:
						confirmState = 0;
						break;
					}
				}
			}
			else if(keyCode == KeyEvent.VK_BACK_SPACE) {
				//when backspace is pressed
				if(currentState == SHOP_STATE) {
					//if state is shopState
					switch(confirmState) {
					case 0:
						currentState = GAME_STATE;
						break;
					case 1:
						confirmState = 0;
						break;
					case 2:
						currentState = GAME_STATE;
					}
				}
				else if(currentState == HELP_STATE) {
					currentState = MENU_STATE;
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
					cupcake.width = (int) (cupcake.width/1.25);
					cupcake.height = (int) (cupcake.height/1.25);	
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
		
		if(keyCode == KeyEvent.VK_SPACE && currentState == GAME_STATE) {
			cupcake.width = (int) (cupcake.width*1.25);
			cupcake.height = (int) (cupcake.height*1.25);	
		}
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
