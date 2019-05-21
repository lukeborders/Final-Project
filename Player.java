import javafx.scene.shape.*;
public class Player {
	private int xPos;
	private int yPos;
	private Rectangle playerSprite;
	private double yVelocity;
	public Player(int x, int y, int height, int width, double yv) {
		xPos = x;
		yPos = y;
		yVelocity = yv;
		playerSprite = new Rectangle(height,width,x,y);	
	}
	public Rectangle update(double etime) { //needs to update position according to the time elapsed;
		yPos += yVelocity * etime;	
	}
	public void render() {
		playerSprite = new Rectangle(height,width,xPos,yPos);		
	}
}
