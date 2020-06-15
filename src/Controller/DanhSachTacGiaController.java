package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DAOs.ContactDAO;
import Model.TacGia;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DanhSachTacGiaController implements Initializable {
	@FXML
	private TableView<TacGia> ListTableTG;
	@FXML
	private TableColumn<TacGia, String> MaTGColumn;
	@FXML
	private TableColumn<TacGia, String> TenTGColumn;
	@FXML
	private TableColumn<TacGia, String> NgaysinhColumn;
	@FXML
	private TableColumn<TacGia, String> QuoctichColumn;
	@FXML
	private TableColumn<TacGia, String> GhichuColumn;
	@FXML
	private Button btThem;
	@FXML
	private Button btXoa;
	private Main mainApp;
	public static Stage TaoTacGiaStage;
	
	public DanhSachTacGiaController() {
		
	}
	ContactDAO contact = new ContactDAO();
	public List<TacGia> getTacGia(){
		List<TacGia> listtg  = contact.getTacGia();
		ObservableList<TacGia> tacgia = FXCollections.observableArrayList(listtg);
		return listtg;
	}
	public void TaoTacGia(ActionEvent event) throws IOException{
		QuanLyMuonSachControllers.TacgiaStage.close();
		Parent TacGiaScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/TaoTacGia.fxml"));
		Scene TacGiaScene = new Scene(TacGiaScenefxml);
		Stage TacGiaStage = new Stage();
		TacGiaStage.setScene(TacGiaScene);
		TacGiaStage.setTitle("Tạo tác giả");
		
		TacGiaStage.initModality(Modality.WINDOW_MODAL);
		TacGiaStage.initOwner(Main.primaryStage);
		
		this.TaoTacGiaStage = TacGiaStage;
		
		TacGiaStage.show();	
	}
	@FXML
	public void handleDeletePerson() {
		 int selectedIndex = ListTableTG.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		        ListTableTG.getItems().remove(selectedIndex);
		    } else {
		        // Nothing selected.
		        Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(mainApp.getPrimaryStage());
		        alert.setTitle("No Selection");
		        alert.setHeaderText("No Person Selected");
		        alert.setContentText("Please select a person in the table.");

		        alert.showAndWait();
	}
}
	public void initialize(URL location, ResourceBundle resource) {
		MaTGColumn.setCellValueFactory(new PropertyValueFactory<>("MaTacGia"));
		TenTGColumn.setCellValueFactory(new PropertyValueFactory<>("HoTen"));
		NgaysinhColumn.setCellValueFactory(new PropertyValueFactory<>("NgaySinh"));
		QuoctichColumn.setCellValueFactory(new PropertyValueFactory<>("QuocTich"));
		GhichuColumn.setCellValueFactory(new PropertyValueFactory<>("GhiChu"));
		ListTableTG.getItems().setAll(getTacGia());
	}
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
}
