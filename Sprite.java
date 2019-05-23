public abstract class Sprite 
{
	private int xPos;
	private int yPos;
	private double yVelocity;
	public Sprite(int x, int y,double yv)
	{
		xPos = x;
		yPos = y;
		yVelocity = yv;

	}
	public abstract void update(double etime);
	
	public abstract int getXPos();
	
	public abstract int getYPos(); 
	
	public abstract void setXPos(int newX);

	public abstract void setYPos(int newY);
	
	
	public abstract int getCurrentXPos();
	public abstract void setCurrentXPos(int newXPos);
}
