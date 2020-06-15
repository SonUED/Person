package Views;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import DAOs.ContactDAO;
import DateUtil.DateUtil;
import Model.DocGia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateControllers{
	private static DocGia docGiaChon;
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
	@FXML 
	private Button btUpdate;
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
	private Stage EditStage;
	private DocGia docgia;
	public static void setDocGiaChon(DocGia dg){
		docGiaChon = dg;
	}
	
	public String converLocalDate(LocalDate ld) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String kq = ld.format(formatter);
		return kq;
	}

	public void setEditStage(Stage EditStage) {
		this.EditStage = EditStage;
	}
	@FXML
	private void initialize() {
//		ListTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->ShowEdit(newValue));
	}
	
	public void ShowEdit(DocGia docgia) {
		
			this.docgia = docgia;
			tfMaDG.setText("1233131313");
			tfHoTen.setText("1346456131");
			dpNgaySinh.setPromptText("11/11/1999");
			dpDangKy.setPromptText("11/11/1999");
			dpGiaHan.setPromptText("11/11/1999");
			tfGhiChu.setText("Ghi cc");
			System.out.println(tfHoTen);
			System.out.println("Chua toi day");
		}
	
	public void Update() {
		
		String HoTen = tfHoTen.getText();
		String GhiChu = tfGhiChu.getText();
		String MaDG = tfMaDG.getText();	
		LocalDate GiaHan = dpGiaHan.getValue();
		LocalDate DangKy = dpDangKy.getValue();
		LocalDate NgaySinh = dpNgaySinh.getValue();
		ContactDAO connect = new ContactDAO();
		DocGia dgNew = new DocGia();
		dgNew.setMaDocGia(MaDG);
		dgNew.setHoTen(HoTen);
		dgNew.setNgayGiaHan(converLocalDate(GiaHan));
		dgNew.setNgayDangKy(converLocalDate(DangKy));
		dgNew.setNgaySinh(converLocalDate(NgaySinh));
		dgNew.setGhiChu(GhiChu);
		connect.Update(dgNew, docGiaChon);
	
	}
}
