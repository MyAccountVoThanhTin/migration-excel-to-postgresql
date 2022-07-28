package com.example.migrationexcelpostgresql.dto.ImportData;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Data
@ExcelSheet("Ban")
public class BanImport {

    @ExcelCellName("MaBan")
    private String maBan;

    @ExcelCellName("SoBan")
    private Integer soBan;

    @ExcelCellName("SoNguoi")
    @Min(value = 0)
    private Integer soNguoi;

    @ExcelCellName("TrangThai")
    private String trangThai;
}
