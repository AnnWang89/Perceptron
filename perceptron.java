package nn.hw1;
import java.io.File;
import java.util.Scanner;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.net.URL;

import nn.hw1.Controller.MainController;
/*
 * Assignment 1: Perceptron
 * Name: 王君安
 * Student ID: 107502509
 */

public class perceptron extends Application {
	
	public static Stage mainStage;
	public static Scene mainScene;
	public static Slider _learning_rate;
	@Override

	public void start(Stage primaryStage) throws IOException{
		perceptron.mainStage = primaryStage;
	    URL fxmlURL = this.getClass().getResource("views/main.fxml");
	    FXMLLoader loader = new FXMLLoader(fxmlURL);
	    Parent main = loader.load();    
	    mainScene = new Scene(main);
	    mainStage.setTitle("Perceptron");//title name
	    mainStage.setScene(mainScene);//set scene to mainScene
	    
	    //learning rate
	    /*
	    _learning_rate = new Slider(0,1,0.8);
	    _learning_rate.setShowTickLabels(true);
	    _learning_rate.setShowTickMarks(true);
	    _learning_rate.setBlockIncrement(0.01);
	    _learning_rate.setLayoutX(300);
	    _learning_rate.setLayoutY(30);
	    */
	    mainStage.show();//show the Stage
	    
	}

	
	public static void main(String[] args) throws Exception{			
	  		launch(args);
	}
	

	
	
}
