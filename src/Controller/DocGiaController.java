package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import DAOs.ContactDAO;
import Model.DocGia;
import Views.DanhSachNguoiDocController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DocGiaController {
	@FXML
	private Button btThem;
	@FXML
	private DatePicker dpGiaHan;
	@FXML
	private DatePicker dpDangKy;
	@FXML
	private DatePicker dpNgaySinh;
	@FXML
	private TextField tfHoTen;
	@FXML
	private TextField tfGhiChu;
	@FXML
	private TextField tfMaDG;
	
	public String converLocalDate(LocalDate ld) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String kq = ld.format(formatter);
		return kq;
	}
	public void ThemDocGia(){
		String HoTen = tfHoTen.getText();
		String GhiChu = tfGhiChu.getText();
		String MaDG = tfMaDG.getText();	
		LocalDate GiaHan = dpGiaHan.getValue();
		LocalDate DangKy = dpDangKy.getValue();
		LocalDate NgaySinh = dpNgaySinh.getValue();
		ContactDAO connect = new ContactDAO();
		DocGia dg = new DocGia();
		dg.setMaDocGia(MaDG);
		dg.setHoTen(HoTen);
		dg.setNgayGiaHan(converLocalDate(GiaHan));
		dg.setNgayDangKy(converLocalDate(DangKy));
		dg.setNgaySinh(converLocalDate(NgaySinh));
		dg.setGhiChu(GhiChu);
		System.out.println(HoTen+GhiChu+MaDG);
		connect.Them(dg);
		DanhSachNguoiDocController.NewStage.close();
	}


}

