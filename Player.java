import javafx.scene.shape.*;
public class Player {
	private int xPos;
	private int yPos;
	private boolean lorf; //true if left key pressed, false if right key pressed
	//private int laneNum; // 0 for lane one, 1 for lane two , and 2 for lane three
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
