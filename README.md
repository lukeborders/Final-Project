# Final-Project
Final Project 

In Main.java there is a tutorial that pretty much explains simple javaFX so read it if u want

Some other things to note:
We r gonna need to use 2d shapes no matter what we do.
basically use the Rectangle class:
    Rectangle rect = new Rectangle();
    rect.setX(10);  
    rect.setY(20);   
    rect.setWidth(100);  
    rect.setHeight(100);
We will need to dynamically change the X and Y positions, but game obstacles will interact with the player based on their height and width!!!
FOR EJEMPLO my idea for a Obstacle class:
  public class Obstacle extends Rectangle {
    private int x;
    private int y;
    private int h;
    private int w;
    public Obstacle(int xPos, int yPos,int height,int width) {
      x = xPos;
      y = yPos
      h = height;
      w = widthl
    }
  }
  And now a little script representing a collision:
    if(player.getXPos() == obstacle.getYPos() && player.getYPos() == obstacle.getYPos()) {
      player.die();
      resetbutton = new Button("Restart");
      resetbutton.setOnAction(new EventHandler<ActionEvent>() {
        stage.reset();
      });
    }
    All assuming we create .die(), .reset(), and all get and set methods and all that.
