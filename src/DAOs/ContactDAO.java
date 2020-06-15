package DAOs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.DocGia;
import Model.DocGiaMuonSach;
import Model.Login;
import Model.TacGia;
import Model.TheLoai;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ContactDAO implements DAO {
	public static Stage LoginStage;
	public Connection getMySqlConnect() {
		Connection connect =null;
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 connect = DriverManager.getConnection(url, user, pass);
			 System.out.println("Connect thanh cong");
		} catch(Exception ex) {
			System.out.println("Connect that bai");
		}
		return connect;	
	}
	private Login createLogin(ResultSet rs1) {
		Login lg = new Login();
		try {
			lg.setUser(rs1.getString("Userr"));
			lg.setPass(rs1.getString("Pass"));
		}catch (SQLException ex) {
			System.out.println("Khong the ket noi den danh sach tai createTheLoai ");
		}
		return lg;
	}
//	public void Login(Login lg) {
//		String sql = "SELECT * FROM TaiKhoan WHERE Userr = ?, Pass= ?";
//		try {
//			
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		Connection conn = getMySqlConnect();
//		Statement stt = conn.createStatement();
//		ResultSet rs1 = stt.executeQuery(sql);
//		if(rs1.next()) {
//			Login login = createLogin(rs1);
//			System.out.println("Dang nhap thanh cong");
//			Parent Loginfxml = FXMLLoader.load(getClass().getClassLoader().getResource("Views/QuanLyMuonSach.fxml"));
//			Scene LoginScene = new Scene(Loginfxml);
//			Stage LoginStage = new Stage();
//			LoginStage.setScene(LoginScene);
//			LoginStage.setTitle("Quản lý thư viện");
//			
//			LoginStage.initModality(Modality.WINDOW_MODAL);
//			LoginStage.initOwner(Main.primaryStage);
//			this.LoginStage = LoginStage;
//			LoginStage.show();
//		}
//		}catch(Exception ex) {
//			System.out.println("Dang nhap loi");
//		}
//		
//	}
	//==========================Hien thi danh sach DocGia=================================//
	private DocGia createDocGia(ResultSet rs) {
		DocGia docgia = new DocGia();
		try {
			docgia.setMaDocGia(rs.getString("MaDocGia"));
			docgia.setHoTen(rs.getString("HoTen"));
			docgia.setNgaySinh(rs.getString("NgaySinh"));
			docgia.setNgayDangKy(rs.getString("NgayDangKy"));
			docgia.setNgayGiaHan(rs.getString("NgayGiaHan"));
			docgia.setGhiChu(rs.getString("GhiChu"));
		} catch (SQLException ex) {
			System.out.println("Khong the ket noi den danh sach tai create Doc gia");
		}
		return docgia;
	}	
	public List<DocGia> getDocGia(){
		String sql = "SELECT * FROM DocGia ORDER BY MaDocGia";	
		List<DocGia> list = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = getMySqlConnect();
			Statement stt = conn.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			while (rs.next()) {
				DocGia docgia = createDocGia(rs);
				list.add(docgia);
		}
			rs.close();
			conn.close();
			
	}catch (ClassNotFoundException | SQLException ex) {
		System.out.println("Khong the hien thi danh sach (Kiem tra lai ten cac column)");
	}
		return list;
	}

	//=====================Ket thuc ham hien thi danh sach DocGia=========================//
	
	//====================Hien thi Danh sach Doc Gia Muon Sach =========================//
	private DocGiaMuonSach createDocGiaMS(ResultSet rs2) {
		DocGiaMuonSach docgiams = new DocGiaMuonSach();
		try {
			docgiams.setMaDocGiaMS(rs2.getString("MaDocGia"));
			docgiams.setMaSachMS(rs2.getString("MaSach"));
			docgiams.setNgayMuonMS(rs2.getString("NgayMuon"));
			docgiams.setGhiChuMS(rs2.getString("GhiChu"));
		}catch (SQLException ex) {
			System.out.println("Khong the ket noi den danh sach");
		}
		return docgiams;
	}
	public List<DocGiaMuonSach> getDocGiaMS() {
		String sql = "SELECT * FROM DocGiaMuonSach ORDER BY MaDocGia";
		List<DocGiaMuonSach> listms = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = getMySqlConnect();
			Statement stt = conn.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			while (rs.next()) {
				DocGiaMuonSach docgiams = createDocGiaMS(rs);
				listms.add(docgiams);
			}
			rs.close();
			conn.close();
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println("Khong the hien thi danh sach");
		}
		return listms;
	}
	
	//===========================Ket thuc ham Hien thi Doc Gia Muon Sach===============//
	
	//==========================Hien thi danh sach The Loai ==========================//
	private TheLoai createTheLoai(ResultSet rs1) {
		TheLoai theloai = new TheLoai();
		try {
			theloai.setMaTheLoai(rs1.getString("MaTheloai"));
			theloai.setTen(rs1.getString("Ten"));
			theloai.setGhiChu(rs1.getString("GhiChu"));
		}catch (SQLException ex) {
			System.out.println("Khong the ket noi den danh sach tai createTheLoai ");
		}
		return theloai;
	}
	public List<TheLoai> getTheLoai() {
		String sql = "SELECT * FROM TheLoai";
		List<TheLoai> listtl = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = getMySqlConnect();
			Statement stt = conn.createStatement();
			ResultSet rs1 = stt.executeQuery(sql);
			while (rs1.next()) {
				TheLoai theloai = createTheLoai(rs1);
				listtl.add(theloai);
			}
			rs1.close();
			conn.close();
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println("Khong the hien thi danh sach");
		}
		return listtl;
	}
	//=======================Ket thuc Ham hien thi Danh sach The Loai================//
	
	//======================= Ham hien thi Danh Sach Tac Gia========================//
	private TacGia  createTacGia(ResultSet rs5) {
		TacGia tacgia = new TacGia();
		try {
			tacgia.setMaTacGia(rs5.getString("MaTacGia"));
			tacgia.setHoTen(rs5.getString("HoTen"));
			tacgia.setNgaySinh(rs5.getString("NgaySinh"));
			tacgia.setQuocTich(rs5.getString("QuocTich"));
			tacgia.setGhiChu(rs5.getString("GhiChu"));
			
		}catch(Exception ex) {
			System.out.println("Khong the ket noi den danh sach tai creatTacGia");
		}
		return tacgia;
		}
	
	public List<TacGia> getTacGia() {
		String sql = "SELECT * FROM TacGia";
		List<TacGia> listtg = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = getMySqlConnect();
			Statement stt = conn.createStatement();
			ResultSet rs = stt.executeQuery(sql);
			while(rs.next()) {
				TacGia tacgia = createTacGia(rs);
				listtg.add(tacgia);
			}
			rs.close();
			conn.close();
		}catch(ClassNotFoundException | SQLException ex) {
			System.out.println("Khong the hien thi danh sach");
		}
		return listtg;
	}
	//=======================Ket thuc ham hien thi Danh Sach Tac Gia===============//
	
	public void Them(DocGia dg) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "insert into DocGia(MaDocGia,HoTen,NgaySinh,NgayDangKy,"
					+ "NgayGiaHan,GhiChu) values (?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, dg.getMaDocGia());
			pst.setString(2, dg.getHoTen());
			pst.setString(3, dg.getNgaySinh());
			pst.setString(4, dg.getNgayDangKy());
			pst.setString(5, dg.getNgayGiaHan());
			pst.setString(6, dg.getGhiChu());
			int rs = pst.executeUpdate();
			if(rs>0) {
				System.out.println("Da them thanh cong");
			}
			else {
				System.out.println("Them loi");
			}
		}catch(Exception ex) {
			System.out.println("khong the them");
		}		
	}
	public void ThemDGMS(DocGiaMuonSach dgms) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "insert into DocGiaMuonSach(MaDocGia,MaSach,NgayMuon,GhiChu)"
					+ " values (?,?,?,?)";
			PreparedStatement pst1 = conn.prepareStatement(sql);
			pst1.setString(1, dgms.getMaDocGiaMS());
			pst1.setString(2, dgms.getMaSachMS());
			pst1.setString(3, dgms.getNgayMuonMS());
			pst1.setString(4, dgms.getGhiChuMS());
			int rs = pst1.executeUpdate();
			if(rs>0) {
				System.out.println("Da them thanh cong");
			}
			else {
				System.out.println("Them loi");
			}
		}catch(Exception ex) {
			System.out.println("Khong the them");
		}		
	}
	
	
	public void ThemTacGia(TacGia tacgia) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "insert into TacGia(MaTacGia,HoTen,NgaySinh,QuocTich,GhiChu)"
					+"values(?,?,?,?,?)";
			PreparedStatement pts2 = conn.prepareStatement(sql);
			pts2.setString(1, tacgia.getMaTacGia());
			pts2.setString(2, tacgia.getHoTen());
			pts2.setString(3, tacgia.getNgaySinh());
			pts2.setString(4, tacgia.getQuocTich());
			pts2.setString(5, tacgia.getGhiChu());
			int rs = pts2.executeUpdate();
			if(rs>0) {
				System.out.println("Da them thanh cong");
			}
			else {
				System.out.println("Them loi");
			}
		}catch(Exception ex) {
			System.out.println("Khong the them");
		}
	}

	public void ThemTheLoai(TheLoai tl) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "insert into TheLoai(MaTheloai,Ten,GhiChu)"
					+"values(?,?,?)";
			PreparedStatement pts3 = conn.prepareStatement(sql);
			pts3.setString(1, tl.getMaTheLoai());
			pts3.setString(2, tl.getTen());
			pts3.setString(3, tl.getGhiChu());
			int rs = pts3.executeUpdate();
			if(rs>0) {
				System.out.println("Da them thanh cong");
			}
			else {
				System.out.println("Them loi");
			}
		}catch(Exception ex) {
			System.out.println("Khong the them");
		}
	}
	
	
	
	public void Xoa(DocGia dg) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "delete from DocGia where MaDocGia = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, dg.getMaDocGia());
			int rs = pst.executeUpdate();
			if(rs>0) {
				System.out.println("Da xoa thanh cong");
			}
			else {
				System.out.println("Xoa loi");
			}
		}catch(Exception ex) {
			System.out.println("khong the xoa");
		}		
	}
	public void Update(DocGia dg, DocGia dgOld) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connect = DriverManager.getConnection(url, user, pass);
			String sql = "Update DocGia set MaDocGia =?,HoTen=?,NgaySinh=?,NgayDangKy=?"
					+ ",NgayGiaHan=?,GhiChu=? where  MaDocGia = " + dgOld.getMaDocGia();
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1, dg.getMaDocGia());
			pst.setString(2, dg.getHoTen());
			pst.setString(3, dg.getNgaySinh());
			pst.setString(4, dg.getNgayDangKy());
			pst.setString(5, dg.getNgayGiaHan());
			pst.setString(6, dg.getGhiChu());
			int rs = pst.executeUpdate();
			if(rs>0) {
				System.out.println("Cap nhat thanh cong");
			}
			else {
				System.out.println("Them loi");
			}
		}catch(Exception ex) {
			System.out.println("Khong the cap nhat");
		}
	}

}

