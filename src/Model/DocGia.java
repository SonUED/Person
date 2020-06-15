package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DocGia {
		private final StringProperty MaDocGia;
		private final StringProperty HoTen;
		private final StringProperty NgaySinh;
		private final StringProperty NgayDangKy;
		private final StringProperty NgayGiaHan;
		private final StringProperty GhiChu;
		public DocGia() {
			this(null,null,null,null,null,null);
		}
		public DocGia(String MaDocGia, String HoTen,String NgaySinh,String NgayDangKy,String NgayGiaHan, String GhiChu){
			this.MaDocGia = new SimpleStringProperty(MaDocGia);
			this.HoTen = new SimpleStringProperty(HoTen);
			this.NgaySinh = new SimpleStringProperty(NgaySinh);
			this.NgayDangKy = new SimpleStringProperty(NgayDangKy);
			this.NgayGiaHan = new SimpleStringProperty(NgayGiaHan);
			this.GhiChu = new SimpleStringProperty(GhiChu);
		}
		public String getMaDocGia() {
			return MaDocGia.get();
		}
		public void setMaDocGia(String MaDocGia) {
			this.MaDocGia.set(MaDocGia);
		}
		public StringProperty MaDocGiaProperty() {
			return MaDocGia;
		}
		public String getHoTen() {
			return HoTen.get();
		}
		public void setHoTen(String HoTen) {
			this.HoTen.set(HoTen);
		}
		public StringProperty HoTenProperty() {
			return HoTen;
		}
		public String getNgaySinh() {
			return NgaySinh.get();
		}
		public void setNgaySinh(String NgaySinh) {
			this.NgaySinh.set(NgaySinh);
		}
		public StringProperty NgaySinhProperty() {
			return NgaySinh;
		}
		public String getNgayDangKy() {
			return NgayDangKy.get();
		}
		public void setNgayDangKy(String NgayDangKy) {
			this.NgayDangKy.set(NgayDangKy);
		}
		public StringProperty NgayDangKyProperty() {
			return NgayDangKy;
		}
		public String getNgayGiaHan() {
			return NgayGiaHan.get();
		}
		public void setNgayGiaHan(String NgayGiaHan) {
			this.NgayGiaHan.set(NgayGiaHan);
		}
		public StringProperty NgayGiaHanProperty() {
			return NgayGiaHan;
		}
		public String getGhiChu() {
			return GhiChu.get();
		}
		public void setGhiChu(String ghiChu) {
			this.GhiChu.set(ghiChu);;
		}
		public StringProperty GhiChuProperty() {
			return GhiChu;
		}
		@Override
		public String toString() {
			return "DocGia [MaDocGia=" + MaDocGia + ", HoTen=" + HoTen + ", NgaySinh=" + NgaySinh + ", NgayDangKy="
					+ NgayDangKy + ", NgayGiaHan=" + NgayGiaHan + ", GhiChu=" + GhiChu + "]";
		}
		
	}
