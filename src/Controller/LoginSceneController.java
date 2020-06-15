package Controller;

import java.io.IOException;
import java.net.URL;

import DAOs.ContactDAO;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Model.Login;

public class LoginSceneController {	
		/* Username and Password for Administration */
		private final String adminuser = "1";
		private final String adminpass = "1";

		@FXML
		private TextField txtUsername;

		@FXML
		private PasswordField txtPassword;

		@FXML
		private Button btnLogIn;
		
		public static Stage MenuStage;
		
		/* Check username and password (empty, correct) */
		public int checkLogin() {
			String username = txtUsername.getText();
			String password = txtPassword.getText();
			int temp = 10;

			if ((username.isEmpty()) || (password.isEmpty())) {
				temp = 1; /* username or password is empty */
			} else {
				if ((username.equals(adminuser)) && (password.equals(adminpass))) {
					temp = 0; /* username or password is incorrect */
				}
			}

			return temp;
		}

		/* Log in Manage Student System */
		public void LogIn(ActionEvent event) {
			switch (checkLogin()) {
			case 1: {
				Alert erroralert = new Alert(AlertType.ERROR);
				erroralert.setTitle("Error");
				erroralert.setHeaderText("Username or Password is empty!");
				erroralert.setContentText("Please fill out this form!");
				erroralert.show();
				break;
			}
			case 10: {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("Username or Password is incorrect!");
				alert.setContentText("Please try again!");
				alert.show();
				break;
			}
			case 0: {
				try {
//				Main.primaryStage.
				Parent Menufxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/QuanLyMuonSach.fxml"));
				Scene MenuScene = new Scene(Menufxml);
				Stage MenuStage = new Stage();
				MenuStage.setScene(MenuScene);
				MenuStage.setTitle("Quản lý mượn sách");
				MenuStage.initModality(Modality.WINDOW_MODAL);
				MenuStage.initOwner(Main.primaryStage);
				this.MenuStage = MenuStage;
				MenuStage.show();
				break;
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			}
		}

		public void setLoginStage(Stage loginStage) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
