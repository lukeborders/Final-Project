//basic javafx app
//import necessary packages before method usage.
import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import java.utils.Color


public class Main extends Application{ //extend application 
    public void start(Stage stage) { // stage is basically a window; also start method is run when the program is run so everything that needs to be done when the program first starts is to be put here
        Button startButton = new Button("Start"); // example of a node or element is a button
        StackPane root = new StackPane(); // StackPanes basically are like a base node to put all other nodes on. Also nodes have like a hierarchy. Will explain in class.
        root.getChildren().add(startButton); //adds the button (child) node to the root StackPane (parent). If for some reason you dont understand the hierarchy concept and the Parent-->child read up on a gosh darn JavaFX tutorial  
        Scene mainScene = new Scene(root,600,400); // creates a scene which is basically a window right? I have no idea bud. Well it has a 600x400 WidthxLength so not sure if window or what
        stage.setScene(mainScene); //sets the scene for the stage i guess.
        stage.setTitle("Dumb Temple run knockoff"); //just makes a title for the scene
        stage.show(); // its literally in the method name.
        Group sprites = new Group();
        int initX = 200;
        int initY = 150;
      
        //attempt on a game loop:
        //using tutorial on nano time:
        final long startTime = System.nanoTime(); //variable for storing the start of the game  I think
        new AnimationTimer() { //creates a timer that is called in each frame 
            public void handle(long currentTime) {
                double elapsed = (currentTime - startTime)/1000000000.0; //variable for storing the calculated elapsed time
                
                
                startButton.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent arg0) {
                        StackPane gamePane = new StackPane();
                        Scene game = new Scene(gamePane,600,400);
                        stage.setScene(game);
                        stage.show();
                        Canvas canvas = new Canvas(600,400);
                        Player player = new Player(initX,initY,20,20,0); //y velocity is placeholder
                        
                       /* Rectangle r = new Rectangle()
                        r.setWidth(20);
                        r.setHeight(20);
                        r.setFill(Color.blue);   
                        sprites.getChildren().add(r); */
                        
                        //sprites.getChildren().add(player);
                }
                    EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
                        public void handle(KeyEvent event) {
                            if(event.getCode() == keyCode.RIGHT) {
                                //player.xPosition += 100;  assuming each lane is about 100 or so pixels wide
                                //player.update(); will create a update method that will update the player
                            }
                        }
                    }
                    EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
                        public void handle(keyEvent event) {
                            if(event.getCode() == keyCode.LEFT) {
                                //player.getXPosition() += -100
                                //player.update();
                            }
                        }
                    }
                });
            }.start();
        }
    public static void Main(String[] args) { //ALWAYS NEED A MAIN METHOD ;)
        launch(args); //method that launches the program when main method is called on startup.
    }

   
}
