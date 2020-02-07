import java.awt.Graphics;

public class Cupcake {

	int cupcakeType; //functionality to make different cupcake types later
	
	//chocolate cupcake width/height - can be edited if new cupcake types are added
	int width = (int) (379/1.5);
	int height = (int) (512/1.5);
	
	Cupcake(int cupcakeType) {
		this.cupcakeType = cupcakeType;
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.chocolateCupcakeImg, (CupcakeClicker.HEIGHT-height)/2, (CupcakeClicker.WIDTH-width)/2, width, height, null); //draws cupcake
	}
	
}
