import java.awt.Dimension;

import javax.swing.JFrame;

public class CupcakeClicker {

	//width and height variables
	final static int WIDTH = 800;
	final static int HEIGHT = 500;
	
	//makes screen variables
	JFrame frame;
	GamePanel panel;
	
	public static void main(String[] args) {
		//sets up game
		CupcakeClicker game = new CupcakeClicker();
		game.setup();
	}
	
	CupcakeClicker() {
		//initialized screen variables
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	void setup() {
		//sets up screen
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.show();
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.startGame();
	}
	
}
