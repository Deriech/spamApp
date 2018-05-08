/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spamapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author derie
 */
public class SpamApp extends Application {
    private int spamCounter;
    private final int spamLimit = 10;
    private ImageView image;
    private double imageHeight;
    private double imageWidth;
    private Stage currentStage;
    public void start(Stage primaryStage) {
        try {
                   image = new ImageView(new Image(new FileInputStream("okman.jpg")));
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(SpamApp.class.getName()).log(Level.SEVERE, null, ex);
               }
        imageHeight = image.getImage().getHeight();
        imageWidth = image.getImage().getWidth();
        Button button = new Button("Press me!");
           button.setOnAction(new MyHandler());
           StackPane pane = new StackPane(button);
            Stage stage = new Stage();
            Scene scene = new Scene(pane,imageWidth,imageHeight);
            stage.setScene(scene);
            stage.show();
            currentStage = stage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private class MyHandler implements EventHandler<ActionEvent>{


        @Override
        public void handle(ActionEvent event) {
           if(spamCounter < spamLimit){
               currentStage.hide();
           Button button = new Button("Press me!");
           button.setOnAction(this);
           StackPane pane = new StackPane(button);
            Stage stage = new Stage();
            Scene scene = new Scene(pane,imageWidth,imageHeight);
            stage.setScene(scene);
            stage.show();
            currentStage = stage;
            stage.setX((Math.random()*250)+100);
            stage.setY((Math.random()*250)+100);
            spamCounter++;
           }
           else{
            currentStage.hide(); 
            Stage stage = new Stage();
            StackPane pane = new StackPane(image);
            Scene scene = new Scene(pane,imageWidth,imageHeight);
            stage.setScene(scene);
            currentStage = stage;
            stage.show();
           }
            
        }
    }
}
