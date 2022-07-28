package com.example.migrationexcelpostgresql.dto.ImportData;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ExcelSheet("KhachHang")
public class KhachHangImport {

    @ExcelCellName("MaKH")
    @NotEmpty(message = "Ma Khach Hang Trong !")
    @Pattern(regexp = "^KH-*",
            message = "Ma Khach Hang Phai Bat Dau Bang NV-")
    private String maKH;

    @ExcelCellName("TenKH")
    @NotEmpty(message = "Ten Khach Hang Trong !")
    private String tenKH;

    @ExcelCellName("GioiTinh")
    @NotEmpty(message = "Gioi Tinh Khach Hang Trong !")
    @Pattern(regexp = "^0$|1$",
            message = "Gioi Tinh Bat Dau Bang 0 Hoac 1")
    private Integer gioiTinh;

    @ExcelCellName("NgaySinh")
    @NotEmpty(message = "Ngay Sinh Khach Hang Trong !")
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",
            message = "Ngay Sinh Phai Dung Dinh Dang dd/mm/yyyy")
    private String ngaySinh;

    @ExcelCellName("SDT")
    @NotEmpty(message = "SDT Khach Hang Trong !")
    @Pattern(regexp = "^0\\d{9}$",
            message = "SDT Phai Co 10 So")
    private String sdt;
}
