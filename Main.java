//basic javafx app
//import necessary packages before method usage.
import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.animation.AnimationTimer;
import java.awt.Color;



public class Main extends Application{ //extend application 
    public void start(Stage stage) { // stage is basically a window; also start method is run when the program is run so everything that needs to be done when the program first starts is to be put here
        Button startButton = new Button("Start"); // example of a node or element is a button
        StackPane root = new StackPane(); // StackPanes basically are like a base node to put all other nodes on. Also nodes have like a hierarchy. Will explain in class.
        root.getChildren().add(startButton); //adds the button (child) node to the root StackPane (parent). If for some reason you dont understand the hierarchy concept and the Parent-->child read up on a gosh darn JavaFX tutorial  
        Scene mainScene = new Scene(root,600,400); // creates a scene which is basically a window right? I have no idea bud. Well it has a 600x400 WidthxLength so not sure if window or what
        stage.setScene(mainScene); //sets the scene for the stage i guess.
        stage.setTitle("Square Game"); //just makes a title for the scene
        stage.show(); // its literally in the method name.
        int initX = 200;
        int initY = 150;
        final Player player = new Player(initX,initY,20,20,0); //y velocity is placeholder
        //attempt on a game loop:
        //using tutorial on nano time:
        final long startTime = System.nanoTime(); //variable for storing the start of the game  I think
        new AnimationTimer() { //creates a timer that is called in each frame 
            public void handle(long currentTime) {
                double elapsed = (currentTime - startTime)/1000000000.0; //variable for storing the calculated elapsed time
                
                startButton.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent arg0) {
                        StackPane gamePane = new StackPane();
                        gamePane.getChildren().add(player.getPlayer());
                        Scene game = new Scene(gamePane,600,400);
                        stage.setScene(game);
                        stage.show();
                        
                       
                    }
                    EventHandler RightKeyEventHandler = new EventHandler<KeyEvent>() {
                        public void handle(KeyEvent event) {
                            if(event.getCode() == KeyCode.RIGHT) {
                                System.out.println("Right Key");
                            }
                        }
                    };
                    EventHandler LeftKeyEventHandler = new EventHandler<KeyEvent>() {
                        public void handle(KeyEvent event) {
                            if(event.getCode() == KeyCode.LEFT) {
                                System.out.println("Left key");
                            }
                        }
                    };
                    //game.addEventHandler(KeyEvent,RightKeyEventHandler);
                    //game.addEventHandler(KeyEvent,LeftKeyEventHandler);
                    //game.add();
                    //p.setOnKeyPressed(RightKeyEventHandler);
                    //p.setOnKeyPressed(LeftKeyEventHandler);
                });
                player.update(elapsed); 
            }
        }.start();
    }
    public static void main(String[] args) { //ALWAYS NEED A MAIN METHOD ;)
        launch(args); //method that launches the program when main method is called on startup.
    }

   
}
