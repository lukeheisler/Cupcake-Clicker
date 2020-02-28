import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Cupcake implements MouseListener {

	int cupcakeType; //functionality to make different cupcake types later
	
	//chocolate cupcake width/height - can be edited if new cupcake types are added
	int width = (int) (379/1.5);
	int height = (int) (512/1.5);
	
	Cupcake(int cupcakeType) {
		this.cupcakeType = cupcakeType;
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.chocolateCupcakeImg, (CupcakeClicker.WIDTH-width)/2, (CupcakeClicker.HEIGHT-height)/2, width, height, null); //draws cupcake
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("owo");
		if(GamePanel.currentState == GamePanel.GAME_STATE) {
			System.out.println("uwu");
		}
		System.out.println();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
