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
    private String maNV;

    @ExcelCellName("TenNV")
    private String tenNhanVien;

    @ExcelCellName("GioiTinh")
    private Integer gioiTinh;

    @ExcelCellName("NgaySinh")
    private String ngaySinh;

    @ExcelCellName("SDT")
    private String sdt;

    @ExcelCellName("DiaChi")
    private String diaChi;
}
