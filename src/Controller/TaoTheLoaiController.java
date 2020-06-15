package Controller;

import java.sql.Connection;

import DAOs.ContactDAO;
import Model.TheLoai;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TaoTheLoaiController {
	@FXML
	private TextField tfMaTL ;
	@FXML
	private TextField tfTenTL;
	@FXML
	private TextField tfGhichu;
	@FXML 
	private Button btThemTL;
	public void ThemTL() {
		String MaTL = tfMaTL.getText();
		String TenTL = tfTenTL.getText();
		String Ghichu = tfGhichu.getText();
		ContactDAO connect = new ContactDAO();
		TheLoai tl = new TheLoai();
		tl.setMaTheLoai(MaTL);
		tl.setTen(TenTL);
		tl.setGhiChu(Ghichu);
		connect.ThemTheLoai(tl);
		
	}
}
