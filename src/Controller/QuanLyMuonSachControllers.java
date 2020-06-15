package Controller;

import java.io.IOException;
import java.net.URL;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class QuanLyMuonSachControllers {
	@FXML
	private Button btDanhsach;
	@FXML
	private Button btLichsu;
	@FXML
	private Button btTacgia;
	@FXML
	private Button btTheloai;
	@FXML
	private Button btTaoTacGia;
	@FXML
	private Button btTaoTheLoai;
	
	private Stage MenuStage;
	public static Stage DanhsachStage;
	
	public static Stage TacgiaStage;
	public static Stage TheloaiStage;
	public static Stage LichsuStage;
	public static Stage TaoDocGiaMSStage;
	public static Stage TaoTacGiaStage;
	public void setMenuStage(Stage MenuStage) {
		this.MenuStage = MenuStage;
	}
	
	public Stage getMenuStage() {
		return MenuStage;
	}
	public void Danhsach(ActionEvent event) throws IOException {
		
		Parent ListScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/DanhSachNguoiDoc.fxml"));
		Scene ListScene = new Scene(ListScenefxml);
		Stage ListStage = new Stage();
		ListStage.setScene(ListScene);
		ListStage.setTitle("Danh sách");
		
		ListStage.initModality(Modality.WINDOW_MODAL);
		ListStage.initOwner(Main.primaryStage);
		
		this.DanhsachStage = ListStage;
		
		ListStage.show();
	}
	public void Lichsu(ActionEvent event) throws IOException {
		
		Parent LichsuScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/DanhSachMuon.fxml"));
		Scene LichsuScene = new Scene(LichsuScenefxml);
		Stage LichsuStage = new Stage();
		LichsuStage.setScene(LichsuScene);
		LichsuStage.setTitle("Lịch sử người mượn");
		
		LichsuStage.initModality(Modality.WINDOW_MODAL);
		LichsuStage.initOwner(Main.primaryStage);
		
		this.LichsuStage = LichsuStage;
		
		LichsuStage.show();
		
	}
	
	public void Tacgia(ActionEvent event) throws IOException{
		Parent TacgiaScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/DanhSachTacGia.fxml"));
		Scene TacgiaScene = new Scene(TacgiaScenefxml);
		Stage TacgiaStage = new Stage();
		TacgiaStage.setScene(TacgiaScene);
		TacgiaStage.setTitle("Tác giả");
		TacgiaStage.initModality(Modality.WINDOW_MODAL);
		TacgiaStage.initOwner(Main.primaryStage);
		this.TacgiaStage = TacgiaStage;
		TacgiaStage.show();
}
	public void Theloai(ActionEvent event) throws IOException{
		Parent TheloaiScenefxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/DanhSachTheLoai.fxml"));
		Scene TheloaiScene = new Scene(TheloaiScenefxml);
		Stage TheloaiStage = new Stage();
		TheloaiStage.setScene(TheloaiScene);
		TheloaiStage.setTitle("Thể loại");
		TheloaiStage.initModality(Modality.WINDOW_MODAL);
		TheloaiStage.initOwner(Main.primaryStage);
		this.TheloaiStage = TheloaiStage;
		TheloaiStage.show();
	}

	
}
