package Views;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import Controller.QuanLyMuonSachControllers;
import DAOs.ContactDAO;
import Model.DocGia;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.List;


public class DanhSachNguoiDocController implements Initializable{
	@FXML
	public  TableView<DocGia> ListTable;
	
	@FXML
	private TableColumn<DocGia, String> MaDGColumn;
	
	@FXML
	private TableColumn<DocGia, String>HotenColumn;
	
	@FXML
	private TableColumn<DocGia,String> NgaysinhColumn;
	
	@FXML
	private TableColumn<DocGia, String> NgayDKColumn;
	
	@FXML
	private TableColumn<DocGia, String> NgayGHColumn;
	@FXML
	private TableColumn<DocGia, String> GhichuColumn;
	private static DocGia docGiaChon;
	@FXML
	private Label TestLabel;
	@FXML
	private Label Malabel;
	@FXML
	private Label Tenlabel;
	@FXML
	private Label NgaySinhlabel;
	@FXML
	private Label NgayDKlabel;
	@FXML
	private Label NgayGHlabel;
	@FXML
	private Label Ghichulabel;
	@FXML
	private Button btTaoDocGia;
	@FXML
	private Button btXoa;

	@FXML
	private Button btUpdatee;
	public static Stage NewStage;
	public static Stage UpdateStage;
	private Stage EditStage;
	private DocGia docgia;
	public static void setDocGiaChon(DocGia dg){
		docGiaChon = dg;
	}
	private Main mainApp;

	private Stage MenuStage;
	public DanhSachNguoiDocController() {
		
	}

	ContactDAO contact = new ContactDAO();

	public List<DocGia> getDocGia(){
		List<DocGia> list = contact.getDocGia();
		ObservableList<DocGia> docgia = FXCollections.observableArrayList(list);
		return list;
		
	}
	private void showDocGiaOverview(DocGia docgia){
		if(docgia!=null) {
			Malabel.setText(docgia.getHoTen()+docgia.getGhiChu());
//			Malabel.setText(docgia.getMaDocGia());
			Tenlabel.setText(docgia.getHoTen());
			NgaySinhlabel.setText(docgia.getNgaySinh());
			NgayDKlabel.setText(docgia.getNgayDangKy());
			NgayGHlabel.setText(docgia.getNgayGiaHan());
			Ghichulabel.setText(docgia.getGhiChu());
			System.out.println(Tenlabel);
	}
		else {
			Malabel.setText("");
			Tenlabel.setText("");
			NgaySinhlabel.setText("");
			NgayDKlabel.setText("");
			NgayGHlabel.setText("");
			Ghichulabel.setText("");
			
		}
	}
	public void TaoDocGia(ActionEvent event) throws IOException {
//		QuanLyMuonSachControllers.DanhsachStage.close();
		Parent NewScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/DocGia.fxml"));
		Scene NewScene = new Scene(NewScenefxml);
		Stage NewStage = new Stage();
		NewStage.setScene(NewScene);
		NewStage.setTitle("Tạo người đọc");
		
		NewStage.initModality(Modality.WINDOW_MODAL);
		NewStage.initOwner(Main.primaryStage);
		
		this.NewStage = NewStage;
		
		NewStage.show();
	}
	@FXML
	public void handleDeletePerson() {
		 int selectedIndex = ListTable.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		        DocGia dg = new DocGia();
		        dg = ListTable.getItems().remove(selectedIndex);
		        ContactDAO connect = new ContactDAO();
		        connect.Xoa(dg);
		    } else {
		        // Nothing selected.
		        Alert alert = new Alert(AlertType.WARNING);
//		        alert.initOwner(mainApp.getPrimaryStage());
		        alert.setTitle("No Selection");
		        alert.setHeaderText("No Person Selected");
		        alert.setContentText("Please select a person in the table.");

		        alert.showAndWait();
	}
}

	
	public void Update() throws IOException {
		int selectedIndex = ListTable.getSelectionModel().getSelectedIndex();
		if(selectedIndex>=0) {
			QuanLyMuonSachControllers.DanhsachStage.close();
			AnchorPane Updatefxml = (AnchorPane) FXMLLoader.load(Main.class.getResource("/Views/UpdateScene.fxml"));
			Scene UpdateScene = new Scene(Updatefxml);
			Stage UpdateStage = new Stage();
			UpdateStage.setScene(UpdateScene);
			UpdateStage.setTitle("Edit Đọc giả");
			UpdateStage.initModality(Modality.WINDOW_MODAL);
			UpdateStage.initOwner(Main.primaryStage);
			UpdateControllers.setDocGiaChon(ListTable.getSelectionModel().getSelectedItem());
			this.UpdateStage = UpdateStage;
			
			UpdateStage.show();}
		else {
			 Alert alert = new Alert(AlertType.WARNING);
		       alert.initOwner(mainApp.getPrimaryStage());
		       alert.setTitle("No Selection");
		        alert.setHeaderText("No Person Selected");
		        alert.setContentText("Please select a person in the table.");

		        alert.showAndWait();
		}
	}
	
	public void initialize(URL location, ResourceBundle resource) {
		MaDGColumn.setCellValueFactory(new PropertyValueFactory<>("MaDocGia"));
		HotenColumn.setCellValueFactory(new PropertyValueFactory<>("HoTen"));
//		NgaysinhColumn.setCellValueFactory(new PropertyValueFactory<>("NgaySinh"));
//		NgayDKColumn.setCellValueFactory(new PropertyValueFactory<>("NgayDangKy"));
//		NgayGHColumn.setCellValueFactory(new PropertyValueFactory<>("NgayGiaHan"));
//		GhichuColumn.setCellValueFactory(new PropertyValueFactory<>("GhiChu"));
		ListTable.getItems().setAll(getDocGia());
			showDocGiaOverview(null);
		
		ListTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->showDocGiaOverview(newValue));
	}
	 public void setMainApp(Main mainApp) {
	        this.mainApp = mainApp;
}
}