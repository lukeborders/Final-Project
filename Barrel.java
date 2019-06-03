import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Barrel extends Obstacle {
    private int xPos;
    private int yPos;
    private int ycurrentPosition;
    private int xcurrentPosition;

    //private double yVelocity;
    private int radius;
    //private Circle bounds;
    //private int ycurrentPosition;
    private Circle barrel;
    private double yVelocity = 35;
    public Barrel(int x,int y,double yv, int r) {
        super(x,y,yv);
        radius = r;
        barrel = new Circle(x,y,r);
        barrel.setFill(Color.BURLYWOOD);
    }
    public Circle getBarrel() {
        return barrel;
    }
    public double getYVelocity() {
        return yVelocity;
    }

}
