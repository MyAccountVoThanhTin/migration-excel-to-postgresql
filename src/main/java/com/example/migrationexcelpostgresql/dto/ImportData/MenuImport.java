package com.example.migrationexcelpostgresql.dto.ImportData;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@ExcelSheet("Menu")
public class MenuImport {

    @ExcelCellName("MaMon")
    private String maMon;

    @ExcelCellName("TenMon")
    private String tenMon;

    @ExcelCellName("DonGia")
    private Double donGia;
}
