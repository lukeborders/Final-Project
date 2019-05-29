import javafx.scene.shape.Rectangle;
public class Obstacle extends Sprite {
    private int xPos;
    private int yPos;
    private double yVelocity;
    //private Rectangle bounds;
    private int ycurrentPosition;
    private int xcurrentPosition;
    private double currentVelocity = 50;
    public Obstacle(int x, int y, double yv) {
        super(x,y,yv);
    }
    public void update(double etime) {
        yVelocity -= etime * yVelocity;
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
    public int getCurrentYPos() {
        return ycurrentPosition;
    }
    public void setCurrentYPos(int newYPos){
        ycurrentPosition = newYPos;
    }
    public void setCurrentXPos(int newXPos) {
        xcurrentPosition = newXPos;
    }
    public int getCurrentXPos() {
        return xcurrentPosition;
    }
    public double getYVelocity(){return yVelocity;}
    public void setYVelocity(double value) {
        yVelocity = value;
    }
    public double getCurrentVelocity() {
        return currentVelocity;
    }
    public void setCurrentVelocity(double value) {
        currentVelocity = value;
    }
    
}
