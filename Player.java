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
	public Player(int x, int y,int h,int w, double yv) {
		super(x,y,yv);
		height = h;
		width = w;
		playerSprite = new Rectangle(x,y,w,h);	
		playerSprite.setFill(Color.BLUE);
	}
	public void update(double etime) { //needs to update position according to the time elapsed;
		yPos += yVelocity * etime;
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
	public void setCurrentXPos(int newXPos) {
		xcurrentPosition = newXPos;
	}
}
