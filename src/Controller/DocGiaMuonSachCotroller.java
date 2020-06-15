package Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import DAOs.ContactDAO;
import Model.DocGiaMuonSach;
import Model.DocGia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DocGiaMuonSachCotroller {
	@FXML
	private Button btThemDGMS;
	@FXML
	private TextField tfMaDG;
	@FXML
	private TextField tfMasach;
	@FXML
	private TextField tfGhichu;
	@FXML
	private DatePicker dpNgayMuon;
	
	public String converLocalDate(LocalDate ld) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String kq = ld.format(formatter);
		return kq;
	}
		
	public void ThemDocGiaMuonSach() {
			String MaDG = tfMaDG.getText();
			String MaSach = tfMasach.getText();
			String Ghichu = tfGhichu.getText();	
			LocalDate NgayMuon = dpNgayMuon.getValue();
			ContactDAO connect = new ContactDAO();
			DocGiaMuonSach dgms = new DocGiaMuonSach();
			dgms.setMaDocGiaMS(MaDG);
			dgms.setMaSachMS(MaSach);		
			dgms.setNgayMuonMS(converLocalDate(NgayMuon));
			dgms.setGhiChuMS(Ghichu);
			connect.ThemDGMS(dgms);
		}
}
	
