public class Player {
  private int xpos;
	private int ypos;
	private int velocity;
	private int height;
	private int width;

  public Player(int x, int y, int v) 
	{
    xpos = X;
		ypos = Y;
		velocity = v;
		new Rectangle(x,y);
  }

    
  public void setX(int x) 
	{
    xpos = x;
  }
	public void setY(int y) 
	{
    ypos = y;
  }
	public void setSpeed(int v) 
	{
    velocity = v;
   }
  public int getXPos() 
	{
    return xpos;
  }
	public int getYPos() 
	{
    return ypos;
  }
	public int getVelocity() 
	{
    return velocity;
  }
}
