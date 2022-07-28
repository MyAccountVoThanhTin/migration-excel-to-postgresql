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
    @NotEmpty(message = "Ma Hoa Don Trong !")
    @Pattern(regexp = "^HD-*",
            message = "Ma Hoa Don Phải Bat Dau Bang NV-")
    private String maHD;

    @ExcelCellName("NgayHD")
    @NotEmpty(message = "Ngay Lap Hoa Don Trong !")
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",
            message = "Ngay Lap Hoa Don Phai Dung Dinh Dang dd/mm/yyyy")
    private String ngayHD;

    @ExcelCellName("ThanhTien")
    @NotEmpty(message = "Thanh Tien Hoa Don Trong !")
    @Min(value = 0)
    private Double thanhTien;

    @ExcelCellName("HinhThucThanhToan")
    @NotEmpty(message = "Hinh Thuc Thanh Toan Cua Hoa Don Trong !")
    private String hinhThucTT;

    @ExcelCellName("MaKH")
    @NotEmpty(message = "Ma Khach Hang Cua Hoa Don Trong !")
    @Min(value = 0)
    private Integer maKH;

    @ExcelCellName("MaNV")
    @NotEmpty(message = "Ma Nhan Vien Cua Hoa Don Trong !")
    @Min(value = 0)
    private Integer maNV;
}
