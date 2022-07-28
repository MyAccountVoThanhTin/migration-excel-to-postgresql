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
    @NotEmpty(message = "Ma Mon Trong !")
    @Pattern(regexp = "^M-*",
            message = "Ma Mon Phải Bat Dau Bang M-")
    private String maMon;

    @ExcelCellName("TenMon")
    @NotEmpty(message = "Ten Mon Mon Trong !")
    private String tenMon;

    @ExcelCellName("DionGia")
    @NotEmpty(message = "Don Gia Mon Mon Trong !")
    @Min(value = 1)
    private Double donGia;
}
