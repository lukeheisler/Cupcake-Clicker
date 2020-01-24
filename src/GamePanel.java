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
		titleFont = new Font("Arial", Font.BOLD, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 24);
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
		/*
		g.setColor(Color.MAGENTA);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.drawString("League Invaders", 60, 100);
		g.setFont(subtitleFont);
		g.drawString("Please press ENTER to begin.", 80, 350);
		g.drawString("Please press SPACE to view instructions.", 30, 500);
		*/
	}
	
	void drawGameState(Graphics g) {
		/*
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		*/
	}
	
	void drawHelpState(Graphics g) {
		/*
		g.setColor(Color.RED);
		g.fillRect(0, 0, CupcakeClicker.WIDTH, CupcakeClicker.HEIGHT);
		g.setColor(Color.BLACK);
		*/
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.MAGENTA);
		g.fillRect(10, 10, WIDTH/2, HEIGHT/2);
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
		repaint();
	}

}
