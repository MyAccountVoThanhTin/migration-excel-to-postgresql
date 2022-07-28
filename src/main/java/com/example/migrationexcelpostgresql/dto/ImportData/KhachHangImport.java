package com.example.migrationexcelpostgresql.dto.ImportData;
import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ExcelSheet("KhachHang")
public class KhachHangImport {

    @ExcelCellName("MaKH")
    private String maKH;

    @ExcelCellName("TenKH")
    @NotEmpty(message = "Ten Khach Hang Trong !")
    private String tenKH;

    @ExcelCellName("GioiTinh")
    private String gioiTinh;

    @ExcelCellName("NgaySinh")
    private String ngaySinh;

    @ExcelCellName("SDT")
    private String sdt;
}
