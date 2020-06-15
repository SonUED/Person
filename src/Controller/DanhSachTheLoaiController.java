package Controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAOs.ContactDAO;
import Model.TheLoai;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.List;

public class DanhSachTheLoaiController implements Initializable {
	@FXML
	private TableView<TheLoai> ListTableTL;
	@FXML
	private TableColumn<TheLoai, String> MaTLColumn;
	@FXML
	private TableColumn<TheLoai, String> TenColumn;
	@FXML
	private TableColumn<TheLoai, String> GhichuColumn;
	@FXML
	private Button btThemtl;
	@FXML
	private Button btXoaTL;
	public static Stage TaoTheLoaiStage;
	private Main mainApp;
	public DanhSachTheLoaiController() {
		
	}
	ContactDAO contact = new ContactDAO();
	public List<TheLoai> getTheLoai(){
		List<TheLoai> list = contact.getTheLoai();
		ObservableList<TheLoai> theloai =FXCollections.observableArrayList(list);
		return list;
	}
	public void TaoTheLoai(ActionEvent event) throws IOException{
		Parent TheLoaiScenefxmml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/TaoTheLoai.fxml"));
		Scene TheLoaiScene = new Scene(TheLoaiScenefxmml);
		Stage TheLoaiStage = new Stage();
		TheLoaiStage.setScene(TheLoaiScene);
		TheLoaiStage.setTitle("Tạo thể loại");
		
		TheLoaiStage.initModality(Modality.WINDOW_MODAL);
		TheLoaiStage.initOwner(Main.primaryStage);
		
		this.TaoTheLoaiStage = TheLoaiStage;
		TheLoaiStage.show();
}
	@FXML
	public void handleDeletePerson() {
		 int selectedIndex = ListTableTL.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		        ListTableTL.getItems().remove(selectedIndex);
		    } else {
		        // Nothing selected.
		        Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(mainApp.getPrimaryStage());
		        alert.setTitle("Không có người dùng được chọn");
		        alert.setHeaderText("Không có người dùng được chọn !");
		        alert.setContentText("Hãy chọn 1 người dùng ở danh sách !");

		        alert.showAndWait();
	}
	}
	public void initialize(URL url, ResourceBundle resource) {
		MaTLColumn.setCellValueFactory(new PropertyValueFactory<>("MaTheloai"));
		TenColumn.setCellValueFactory(new PropertyValueFactory<>("Ten"));
		GhichuColumn.setCellValueFactory(new PropertyValueFactory<>("GhiChu"));
		ListTableTL.getItems().setAll(getTheLoai());
	}
		    public void setMainApp(Main mainApp) {
		        this.mainApp = mainApp;
	
}
}

