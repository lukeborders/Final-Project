//basic javafx app
//import necessary packages before method usage.
import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;
import javafx.scene.shapes.*;


public class Main extends Application{ //extend application 
    public void start(Stage stage) { // stage is basically a window; also start method is run when the program is run so everything that needs to be done when the program first starts is to be put here
        Button startButton = new Button("Start"); // example of a node or element is a button
        StackPane root = new StackPane(); // StackPanes basically are like a base node to put all other nodes on. Also nodes have like a hierarchy. Will explain in class.
        root.getChildren().add(startButton); //adds the button (child) node to the root StackPane (parent). If for some reason you dont understand the hierarchy concept and the Parent-->child read up on a gosh darn JavaFX tutorial  
        Scene mainScene = new Scene(root,600,400); // creates a scene which is basically a window right? I have no idea bud. Well it has a 600x400 WidthxLength so not sure if window or what
        stage.setScene(mainScene); //sets the scene for the stage i guess.
        stage.setTitle("Dumb Temple run knockoff"); //just makes a title for the scene
        stage.show(); // its literally in the method name.
      
        //attempt on a game loop:
        //using tutorial on nano time:
        final long startTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentTime) {
                double t = (currentTime - startTime)/1000000000.0;
                
                
                startButton.setOnAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent arg0) {
                    StackPane gamePane = new StackPane();
                    Scene game = new Scene(gamePane,600,400);
                    stage.setScene(game);
                    stage.show();
                    Canvas canvas = new Canvas(600,400);
                    //gamePane.getChildren().add(canvas);
                    //Player player = new Player(150,200,10,0,20,20); // considering that the Player class creates a new rectangle2d.
                    //gamePane.getChildren().add(player);

                }
                EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent event) {
                        if(event.getCode() == keyCode.RIGHT) {
                            //move player.
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
