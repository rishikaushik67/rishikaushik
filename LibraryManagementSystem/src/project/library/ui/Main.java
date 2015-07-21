package project.library.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {

		try {
			// Load the root layout from the fxml file
			Parent root = FXMLLoader.load(getClass().getResource("/project/library/ui/SearchMember.fxml"));
	        
	        stage.setTitle("MPP Library");
	        stage.setScene(new Scene(root, 600, 675));
	        stage.show();
			
		} catch (IOException e) {
			// Exception gets thrown if the fxml file could not be loaded
			e.printStackTrace();
		}
		
	}
		
}


