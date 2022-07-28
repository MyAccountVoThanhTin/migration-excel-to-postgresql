package com.example.migrationexcelpostgresql.dto.ImportData;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@ExcelSheet("HoaDon")
public class HoaDonImport {

    @ExcelCellName("MaHD")
    private String maHD;

    @ExcelCellName("NgayHD")
    private String ngayHD;

    @ExcelCellName("ThanhTien")
    private Double thanhTien;

    @ExcelCellName("HinhThucThanhToan")
    private String hinhThucTT;

    @ExcelCellName("MaKH")
    private String maKH;

    @ExcelCellName("MaNV")
    private String maNV;
}
