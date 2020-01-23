import java.awt.Dimension;

import javax.swing.JFrame;

public class CupcakeClicker {

	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	
	JFrame frame;
	GamePanel panel;
	
	public static void main(String[] args) {
		CupcakeClicker game = new CupcakeClicker();
		game.setup();
		
	}
	
	CupcakeClicker() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	void setup() {
		
		frame.getContentPane().setPreferredSize(new Dimension(w,h));
		frame.show();
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.startGame();
		
	}
	
}
