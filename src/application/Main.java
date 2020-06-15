package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.net.URL;

import Model.DocGia;

public class Main extends Application {
	public static Window primaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = getClass().getClassLoader().getResource("Views/LoginScene.fxml");
			Parent root = FXMLLoader.load(url);
			primaryStage.setTitle("My Application");
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static Window getPrimaryStage() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
