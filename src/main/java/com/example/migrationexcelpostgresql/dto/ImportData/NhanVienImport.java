package com.example.migrationexcelpostgresql.dto.ImportData;

import com.example.migrationexcelpostgresql.common.StringUtil;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ExcelSheet("NhanVien")
public class NhanVienImport {

    @ExcelCellName("MaNV")
    @NotEmpty(message = "Ma Nhan Vien Trong !")
    @Pattern(regexp = "^NV-*",
            message = "Ma Nhan Vien Phải Bat Dau Bang NV-")
    private String maNV;

    @ExcelCellName("TenKH")
    @NotEmpty(message = "Ten Nhan Vien Trong !")
    @Size(max = 100, message = "Ten Nhan Vien Vuot Qua 100 Ky Tu")
    private String tenNhanVien;

    @ExcelCellName("GioiTinh")
    @NotEmpty(message = "Gioi Tinh Nhan Vien Trong !")
    @Pattern(regexp = "^0$|1$",
            message = "Gioi Tinh Bat Dau Bang 0 Hoac 1")
    private Integer gioiTinh;

    @ExcelCellName("NgaySinh")
    @NotEmpty(message = "Ngay Sinh Nhan Vien Trong !")
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",
            message = "Ngay Sinh Phai Dung Dinh Dang dd/mm/yyyy")
    private String ngaySinh;

    @ExcelCellName("SDT")
    @NotEmpty(message = "SDT Nhan Vien Trong !")
    @Pattern(regexp = "^0\\d{9}$",
            message = "SDT Phai Co 10 So")
    private String sdt;

    @ExcelCellName("DiaChi")
    @NotEmpty(message = "Dia Chi Nhan Vien Trong !")
    private String diaChi;
}
