package Controller;



import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAOs.ContactDAO;
import Model.DocGiaMuonSach;
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
public class DanhSachMuonController implements Initializable {
		@FXML
		private TableView <DocGiaMuonSach> ListTableMS;
		@FXML
		private TableColumn<DocGiaMuonSach, String> MaDGColumn;
		@FXML
		private TableColumn<DocGiaMuonSach, String> MasachColumn;
		@FXML
		private TableColumn<DocGiaMuonSach, String> NgaymuonColumn;
		@FXML
		private TableColumn<DocGiaController, String> GhichuColumn;
		@FXML
		private Button btTaoDocGiaMS;
		private Main mainApp;

		public static Stage TaoDocGiaMSStage;
		ContactDAO contact =  new ContactDAO();
		public List<DocGiaMuonSach> getDocGiaMS(){
			List<DocGiaMuonSach> list = contact.getDocGiaMS();
			ObservableList<DocGiaMuonSach> docgiams = FXCollections.observableArrayList(list);
			return list;
		}

		public void TaoDocGiaMS(ActionEvent event) throws IOException {
//			QuanLyMuonSachControllers.LichsuStage.close();
			Parent DocGiaMSScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/DocGiaMuonSach.fxml"));
			Scene DocGiaMSScene = new Scene(DocGiaMSScenefxml);
			Stage DocGiaMSStage = new Stage();
			DocGiaMSStage.setScene(DocGiaMSScene);
			DocGiaMSStage.setTitle("Tạo người đọc");
			
			DocGiaMSStage.initModality(Modality.WINDOW_MODAL);
			DocGiaMSStage.initOwner(Main.primaryStage);
			
			this.TaoDocGiaMSStage = DocGiaMSStage;
			
			DocGiaMSStage.show();
		}
		public void initialize(URL location, ResourceBundle resources) {
			MaDGColumn.setCellValueFactory(new PropertyValueFactory<>("MaDocGia"));
			MasachColumn.setCellValueFactory(new PropertyValueFactory<>("MaSach"));
			NgaymuonColumn.setCellValueFactory(new PropertyValueFactory<>("MgayMuon"));
			GhichuColumn.setCellValueFactory(new PropertyValueFactory<>("GhiChu"));
			ListTableMS.getItems().setAll(getDocGiaMS());
		}
		public void setMainApp (Main mainApp) {
			this.mainApp = mainApp;
		}
}
