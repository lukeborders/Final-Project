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
import javafx.scene.media.AudioClip;
import javafx.animation.AnimationTimer;
import javafx.scene.Node.*;
import javafx.application.*;
import javafx.application.Platform;
import javafx.application.Platform.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
public class Main extends Application{ //extend application 
    private static boolean hasRun = false;
    public void start(Stage stage) { // stage is basically a window; also start method is run when the program is run so everything that needs to be done when the program first starts is to be put here
        Button startButton = new Button("START"); // example of a node or element is a button
        Text mainText = new Text("Welcome to the Square Game");
        Text subText = new Text("Please Press START to continue!");
        subText.setFill(Color.LAWNGREEN);
        subText.setTranslateY(-85.0);
        mainText.setFill(Color.BLUE);
        mainText.setTranslateY(-100.0);
        StackPane root = new StackPane(); // StackPanes basically are like a base node to put all other nodes on. Also nodes have like a hierarchy. Will explain in class.
        root.getChildren().add(mainText);
        root.getChildren().add(subText);
        root.getChildren().add(startButton); //adds the button (child) node to the root StackPane (parent). If for some reason you dont understand the hierarchy concept and the Parent-->child read up on a gosh darn JavaFX tutorial  
        Scene mainScene = new Scene(root,600,400); // creates a scene which is basically a window right? I have no idea bud. Well it has a 600x400 WidthxLength so not sure if window or what
        stage.setScene(mainScene); //sets the scene for the stage i guess.
        stage.setTitle("Square Game"); //just makes a title for the scene
        stage.show(); // its literally in the method name.
        int initX = 0;
        int initY = 0;
        StackPane gamePane = new StackPane();
        Scene game = new Scene(gamePane,600,400);
        final Player player = new Player(initX,initY,20,20,0.0); //y velocity is placeholder
        Rectangle p = player.getPlayer();
        Line line1 = new Line(-100,0,-100,500);
        Line line2 = new Line(100,0,100,500);
        Barrel barrel = new Barrel(0,0,0,20);
        Circle b = barrel.getBarrel();
        AudioClip epicGamerSounds = new AudioClip(this.getClass().getResource("epicgamermusic.wav").toString());
        
       /* MusicOffButton.setOnAction(new EventHandler<ActionEvent>(){ //start button handler
            public void handle(ActionEvent arg0) {
                epicGamerSounds.play();
            }
        }); */
        

//will work on tonight -nat
        startButton.setOnAction(new EventHandler<ActionEvent>(){ //start button handler
            public void handle(ActionEvent arg0) {
                //if(){}
                //else{
                epicGamerSounds.play();
               // }
                b.setTranslateX(((int)(Math.random()*150))); //spawns one barrel of random X-location
                b.setTranslateY(500.0); //should be outside of lines but doesnt work
                gamePane.getChildren().add(p);
                System.out.println(p);
                gamePane.getChildren().add(line1);
                gamePane.getChildren().add(line2);
                gamePane.getChildren().add(b);
                line1.setTranslateX(-200.0);
                line2.setTranslateX(200.0);
                stage.setScene(game);
                stage.show();

            }
        });
        
        EventHandler<KeyEvent> RightKeyEventHandler = new EventHandler<KeyEvent>() { //detects right key press for future movement
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.RIGHT) {
                    if(player.getCurrentXPos() < 150) {
                        System.out.println("Right Key");
                        player.setCurrentXPos(player.getXPos()+50);
                        player.setXPos(player.getCurrentXPos());
                        player.render();
                        event.consume();
                    }
                }  
            }
        };

        EventHandler<KeyEvent> LeftKeyEventHandler = new EventHandler<KeyEvent>() { //detects left key press for future movement
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.LEFT) {
                    System.out.println("Left key");
                    if(player.getCurrentXPos() > -150) {
                        player.setCurrentXPos(player.getXPos()-50);
                        player.setXPos(player.getCurrentXPos());
                        System.out.println("Current Position: " + player.getCurrentXPos());
                        player.render();
                    }
                    
                    
                    event.consume();
                }
            };
        };
        EventHandler<KeyEvent> escapeHandler = new EventHandler<KeyEvent>() { //detects escape key press for closing window
            public void handle(KeyEvent event) {
                if(event.getCode()==KeyCode.ESCAPE) {
                    stage.close();
                    System.out.println("Application Closed");
                }
            }
        };

        /* all registrations and usages of handlers */
        game.addEventHandler(KeyEvent.KEY_PRESSED,escapeHandler);
        game.addEventHandler(KeyEvent.KEY_PRESSED,RightKeyEventHandler);
        game.addEventHandler(KeyEvent.KEY_PRESSED,LeftKeyEventHandler);
        game.setOnKeyPressed(RightKeyEventHandler);
        game.setOnKeyPressed(LeftKeyEventHandler);
        game.setOnKeyPressed(escapeHandler);

        final long startTime = System.nanoTime(); //variable for storing the start of the game  I think
        new AnimationTimer() { 
            public void handle(long currentTime) {
                double elapsed = (currentTime - startTime)/1000000000.0; //variable for storing the calculated elapsed time
                if(Platform.isFxApplicationThread()==true) {
                    p.setTranslateX(player.getXPos());
                    simulateObjectVelocity(barrel,elapsed);
                }
                //everything that needs to be updated 60 times per second
                player.update(elapsed);
                
            }
            
        }.start();
    }
    public static void main(String[] args) { //ALWAYS NEED A MAIN METHOD ;)
        launch(args); //method that launches the program when main method is called on startup.
    }
    public static void simulateObjectVelocity(Barrel param,double elapsed) {
        double accelerationMultiplier = 1.50;
        double start = System.nanoTime();
        double elapsedTime = elapsed;
        
        
        double distance = param.getYVelocity() * elapsedTime;
        double currentVelocity = 50.0;
        param.setYVelocity(currentVelocity);
        if((((int)elapsed) % 2) == 0) {
            currentVelocity = currentVelocity * accelerationMultiplier;
            param.setYVelocity(currentVelocity);            
        }
        param.getBarrel().setTranslateY(distance);
        System.out.println(param.getYVelocity());
        System.out.println(elapsed);

        
        
    }
    public static void simulateObjectVelocity(Barrel param,double elapsed) {
        double accelerationMultiplier = (1.1);
        double start = System.nanoTime();
        double elapsedTime = elapsed;
        

        double distance = param.getYVelocity() * elapsedTime;
        double currentVelocity = param.getCurrentVelocity();
        if((((int)elapsed) % 2) == 0 && hasRun == false) {
            currentVelocity = currentVelocity * accelerationMultiplier;
            param.setCurrentVelocity(currentVelocity);
            param.setYVelocity(currentVelocity);
            System.out.println((((int)elapsed) % 2));
            hasRun = true;
        }
        else {
            hasRun = false;
        }

       // param.setRadius(param.getRadius() * 50);
        param.getBarrel().setTranslateY(distance);
        System.out.println(param.getYVelocity());
        System.out.println(elapsed);

        
        
    }
}
