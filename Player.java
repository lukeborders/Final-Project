import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
public class Player extends Sprite {
	private int xPos;
	private int yPos;
	private int height;
	private int width;
	private Rectangle playerSprite;
	private double yVelocity;
	private int xcurrentPosition;
	private int score;
	public Player(int x, int y,int h,int w, double yv) {
		super(x,y,yv);
		height = h;
		width = w;
		playerSprite = new Rectangle(x,y,w,h);	
		playerSprite.setFill(Color.BLUE);
	}
	public void render() {
		playerSprite = new Rectangle(xPos,yPos,width,height);		
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
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public Rectangle getPlayer() {
		return playerSprite;
	}
	public int getCurrentXPos() {
		return xcurrentPosition;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int value) {
		score = value;
	}
	public void setCurrentXPos(int newXPos) {
		xcurrentPosition = newXPos;
	}
}
