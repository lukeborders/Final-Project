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
    private static int barrelCount = 0;
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
        Barrel[] barrelarr = new Barrel[2];
        

        AudioClip epicGamerSounds = new AudioClip(this.getClass().getResource("epicgamermusic.wav").toString());
        StackPane go = new StackPane();
        Scene gameOver = new Scene(go,600,400);


        
       /* MusicOffButton.setOnAction(new EventHandler<ActionEvent>(){ //start button handler
            public void handle(ActionEvent arg0) {
                epicGamerSounds.play();
            }
        }); */
        

//will work on tonight -nat
        startButton.setOnAction(new EventHandler<ActionEvent>(){ //start button handler
            public void handle(ActionEvent arg0) {
                epicGamerSounds.play();
                gamePane.getChildren().add(p);
                System.out.println(p);
                gamePane.getChildren().add(line1);
                gamePane.getChildren().add(line2);

                line1.setTranslateX(-200.0);
                line2.setTranslateX(200.0);
                stage.setScene(game);
                stage.show();
                for(int i = 0; i < barrelarr.length; i++) {
                    Barrel s = new Barrel(((int)getRandomPosition()),-500,70,20);
                    s.getBarrel().setTranslateX(getRandomPosition());
                    s.getBarrel().setTranslateY(-300.0);

                    barrelarr[i] = s;
                    gamePane.getChildren().add(barrelarr[i].getBarrel());
                    //barrelarr[i].getBarrel().relocate(s.getXPos(),s.getXPos());
                }
                final long startTime = System.nanoTime(); //variable for storing the start of the game  I think
                new AnimationTimer() {
                    public void handle(long currentTime) {
                        double elapsed = (currentTime - startTime)/1000000000.0; //variable for storing the calculated elapsed time
                        if(Platform.isFxApplicationThread()==true) {
                            p.setTranslateX(player.getXPos());
                            for(int i = 0; i < barrelarr.length;i++) {
                                simulateObjectVelocity(barrelarr[i], elapsed);
                                System.out.println(((int)barrelarr[i].getBarrel().getTranslateY()));
                                if(((int)barrelarr[i].getBarrel().getTranslateY() == 300)) {
                                    gamePane.getChildren().remove(barrelarr[i].getBarrel());
                                    barrelarr[i] = new Barrel(((int)getRandomPosition()), -300, 70, 20);
                                    barrelarr[i].getBarrel().setTranslateY(-300);
                                    barrelarr[i].getBarrel().setTranslateX(getRandomPosition());
                                    gamePane.getChildren().add(barrelarr[i].getBarrel());
                                }
                                if(didCollide(player,barrelarr[i])==true) {
                                    stage.setScene(gameOver);
                                    Text gameOverText = new Text("haha ur bad");
                                    gameOverText.setFill(Color.RED);
                                    go.getChildren().add(gameOverText);

                                }

                            }

                            }
                        }
                        //everything that needs to be updated 60 times per second

                }.start();
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


    }
    public static void main(String[] args) { //ALWAYS NEED A MAIN METHOD ;)
        launch(args); //method that launches the program when main method is called on startup.
    }

    public static void simulateObjectVelocity(Barrel param,double elapsed) {
        double accelerationMultiplier = (1.1);
        double start = System.nanoTime();
        double elapsedTime = elapsed;
        double distance = param.getBarrel().getTranslateY() + ((param.getYVelocity()/70) * elapsedTime);
        param.getBarrel().setTranslateY(distance);
        /*if((((int)elapsed) % 2) == 0) {
            //currentVelocity = currentVelocity * accelerationMultiplier;
            param.setCurrentVelocity(currentVelocity);
            param.setYVelocity(currentVelocity);
          //  System.out.println((((int)elapsed) % 2));
        }*/



        //param.setRadius(param.getRadius() * 50);




        //System.out.println(param.getYVelocity());
        //System.out.println(elapsed);



    }
    public static double getRandomPosition() {
        double r = 0.0;
        double[] random = {(Math.random()*150),(Math.random()*-150)};
        int randomI = ((int)(Math.random()*2));
        if(randomI == 1) {
            r = random[0];
        }
        else {
            r = random[1];
        }
        return r;
    }
    public boolean didCollide(Player p,Barrel b) {
        boolean r = false;
        if(p.getXPos() == b.getBarrel().getTranslateX() && b.getBarrel().getTranslateY() == 0) {
            r = true;
        }
        return r;
    }
    public static void respawnObstacle(Barrel b,StackPane gamePane,double elapsed) {
        System.out.println(((int)b.getBarrel().getTranslateY()));
        if(((int)b.getBarrel().getTranslateY() == 300)) {
            gamePane.getChildren().remove(b.getBarrel());
            b = new Barrel(((int)getRandomPosition()), -300, 70, 20);
            b.getBarrel().setTranslateY(-300);
            b.getBarrel().setTranslateX(getRandomPosition());
            gamePane.getChildren().add(b.getBarrel());
        }
    }

}
