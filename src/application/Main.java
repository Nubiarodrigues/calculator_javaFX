package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CalculatorView.fxml"));
			Parent parent = loader.load(); 

			Scene mainScene = new Scene(parent);
			mainScene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm()); 																							

			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Calculator");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
