import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
public class Player {
	private int xPos;
	private int yPos;
	private int height;
	private int width;
	private Rectangle playerSprite;
	private double yVelocity;
	private int currentPosition;
	public Player(int x, int y, int h, int w, double yv) {
		xPos = x;
		yPos = y;
		yVelocity = yv;
		height = h;
		width = w;
		playerSprite = new Rectangle(x,y,height,width);	
		playerSprite.setFill(Color.BLUE);
	}
	public void update(double etime) { //needs to update position according to the time elapsed;
		yPos += yVelocity * etime;
	}
	public void render() {
		playerSprite = new Rectangle(height,width,xPos,yPos);		
		//need to somehow show the new sprite
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void setXPos(int newX) {
		xPos = newX;
	}
	public void setYPos(int newY) {
		yPos = newY;
	}
	public Rectangle getPlayer() {
		return playerSprite;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int newPos) {
		currentPosition = newPos;
	}
}
