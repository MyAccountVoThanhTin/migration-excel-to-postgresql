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
    @NotEmpty(message = "Ma Ban Trong !")
    private String maBan;

    @ExcelCellName("SoBan")
    @NotEmpty(message = "So Ban Trong !")
    @Min(value = 0)
    private Integer soBan;

    @ExcelCellName("SoNguoi")
    @NotEmpty(message = "So Nguoi Trong !")
    @Min(value = 0)
    private Integer soNguoi;

    @ExcelCellName("TrangThai")
    @NotEmpty(message = "Trang Thai Ban Trong !")
    @Pattern(regexp = "^0$|1$",
            message = "Trang Thai Bat Dau Bang 0 Hoac 1")
    private int trangThai;
}
