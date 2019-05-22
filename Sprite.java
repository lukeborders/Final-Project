public abstract class Sprite extends Rectangle
{
	private int height; //height
	private int width; //in pixels
	private int xPos;
	private int yPos;
	public Sprite(int x, int y, int h,int w)
	{
		xPos = x;
		yPos = y;
		height = h;
		width = w;

	}
	public abstract void update(double etime);
	
	public abstract int getXPos();
	
	public abstract int getYPos(); 
	
	public abstract void setXPos(int newX);

	public abstract void setYPos(int newY);
	
	public abstract int getHeight();

	public abstract int getWidth();

}