//basic javafx app
//import necessary packages before method usage.
package application;   
import javafx.application.Application;  
import javafx.event.ActionEvent;  
import javafx.event.EventHandler;  
import javafx.scene.Scene;  
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;


public class Main extends Application{ //extend application 
    public void start(Stage stage) { // stage is basically a window; also start method is run when the program is run so everything that needs to be done when the program first starts is to be put here
        Button startButton = new Button("Start"); // example of a node or element is a button
        StackPane root = new StackPane(); // StackPanes basically are like a base node to put all other nodes on. Also nodes have like a hierarchy. Will explain in class.
        root.getChildren().add(startButton); //adds the button (child) node to the root StackPane (parent). If for some reason you dont understand the hierarchy concept and the Parent-->child read up on a gosh darn JavaFX tutorial  
        Scene exampleScene = new Scene(root,600,400); // creates a scene which is basically a window right? I have no idea bud. Well it has a 600x400 WidthxLength so not sure if window or what 
        stage.setScene(exampleScene); //sets the scene for the stage i guess.
        stage.setTitle("Dumb Temple run knockoff"); //just makes a title for the scene
        stage.show(); // its literally in the method name.
        /*
        OKAY ITS TIME TO MAKE AN EVENT HANDLER FOR THE BUTTON. THIS IS WHAT
        WE ARE GOING TO HAVE TO DO ALOT BECAUSE OF ALL THE BUTTONS WE NEED TO PRESS FOR THIS
        GAME:
        */
        startButton.setOnAction(new EventHandler<ActionEvent>(){ // so setOnAction gives the button an action, which is in the form of an event handler. So in the parameter we need an event handler that is basically like a method its kind of hard to explain.
            public void handle(ActionEvent arg0) { //handle takes a param of the ActionEvent which is basically the press of the button? Not sure will learn more l8r.
                System.out.println("Dumb Dumb temple run"); // printed out somehow when button is pressed. Not sure how all the syntax works with the eventhandler and all but we will prevail
            }
        }); 


    }
    public static void Main(String[] args) { //ALWAYS NEED A MAIN METHOD ;)
        launch(args); //method that launches the program when main method is called on startup.
    }

    // For some reason when I run it on my computer i get a error that the Main class cannot be found. 
    // Will ask Ms. Adams bc I cant find anything about fixing it online so it makes no sense.
}
