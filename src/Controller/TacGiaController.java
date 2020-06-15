package Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import DAOs.ContactDAO;
import Model.TacGia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TacGiaController {
	@FXML
	private Button btThem;
	@FXML
	private TextField tfMaTacGia;
	@FXML
	private TextField tfHoTen;
	@FXML
	private TextField tfGhichu;
	@FXML
	private TextField tfQuocTich;
	@FXML
	private DatePicker dpNgaySinh;
	
	public String converLocalDate(LocalDate ld) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String kq = ld.format(formatter);
		return kq;
	}
	public void ThemTG() {
		String MaTG = tfMaTacGia.getText();
		String Hoten = tfHoTen.getText();
		String Ghichu = tfGhichu.getText();
		String Quoctich = tfQuocTich.getText();
		LocalDate Ngaysinh =dpNgaySinh.getValue();
		ContactDAO connect = new ContactDAO();
		TacGia tacgia = new TacGia();
		tacgia.setMaTacGia(MaTG);
		tacgia.setHoTen(Hoten);
		tacgia.setNgaySinh(converLocalDate(Ngaysinh));
		tacgia.setQuocTich(Quoctich);
		tacgia.setGhiChu(Ghichu);
		connect.ThemTacGia(tacgia);
	}
}
