import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Barrel extends Obstacle {
    private int xPos;
    private int yPos;
    //private double yVelocity;
    private int radius;
    //private Circle bounds;
    //private int ycurrentPosition;
    private Circle barrel;
    private double yVelocity;
    public Barrel(int x,int y,double yv, int r) {
        super(x,y,yv);
        radius = r;
        barrel = new Circle(x,y,r);
        barrel.setFill(Color.BURLYWOOD);
    }
    public Circle getBarrel() {
        return barrel;
    }
}