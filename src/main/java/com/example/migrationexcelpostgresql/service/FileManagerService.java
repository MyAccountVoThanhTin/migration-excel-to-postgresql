package com.example.migrationexcelpostgresql.service;

import com.example.migrationexcelpostgresql.common.FileUtils;
import com.example.migrationexcelpostgresql.common.StringUtil;
import com.example.migrationexcelpostgresql.dao.*;
import com.example.migrationexcelpostgresql.dto.ImportData.*;
import com.example.migrationexcelpostgresql.dto.ImportExcelFileDTO;
import com.example.migrationexcelpostgresql.model.*;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class FileManagerService {

    private static final Logger logger = LoggerFactory.getLogger(FileManagerService.class);
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    KhachHangRepository khachHangRepository;

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    BanRepository banRepository;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Transactional
    public void importExcelData(ImportExcelFileDTO importExcelFileDTO) {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder
                .settings()
                .headerStart(0)
                .caseInsensitive(false)
                .ignoreWhitespaces(true)
                .trimCellValue(true)
                .build();
        File excelFile = FileUtils.convertBase64ToFile(importExcelFileDTO.getFileName(), importExcelFileDTO.getFileContent());
        List<KhachHangImport> dsKhachHang = Poiji.fromExcel(excelFile, KhachHangImport.class, options);
        this.saveDSKhachHang(dsKhachHang);
        List<NhanVienImport> dsNhanVien = Poiji.fromExcel(excelFile, NhanVienImport.class, options);
        this.saveNhanVien(dsNhanVien);
        List<BanImport> dsBan = Poiji.fromExcel(excelFile, BanImport.class, options);
        this.saveBan(dsBan);
        List<MenuImport> dsMenu = Poiji.fromExcel(excelFile, MenuImport.class, options);
        this.saveDSMenu(dsMenu);
        List<HoaDonImport> dsHoaDon = Poiji.fromExcel(excelFile, HoaDonImport.class, options);
        this.saveHoaDon(dsHoaDon);
        excelFile.delete();
    }

    public void saveHoaDon(List<HoaDonImport> hoaDonImports){
        List<HoaDon> listHoaDon = new ArrayList<>();
        if (Objects.nonNull(hoaDonImports) && hoaDonImports.size() > 0) {
            HoaDon hoaDon;
            for (HoaDonImport dto: hoaDonImports){
                hoaDon = new HoaDon();
                hoaDon.setNhanVien(this.checkExistNV(this.conCatMa(2, dto.getMaNV())));
                hoaDon.setKhachHang(this.checkExistKH(this.conCatMa(2, dto.getMaKH())));
                hoaDon.setMaHD(dto.getMaHD());
                hoaDon.setNgayHD(dto.getNgayHD());
                hoaDon.setThanhTien(dto.getThanhTien());
                hoaDon.setHinhThucTT(dto.getHinhThucTT());
                listHoaDon.add(hoaDon);
            }
        }
        hoaDonRepository.saveAll(listHoaDon);
    }
    public KhachHang checkExistKH(String maKH){
        if(StringUtil.isEmpty(maKH)){
            return null;
        }
        KhachHang khachHang = khachHangRepository.findKhachHangByMaKH(maKH);
        return Objects.nonNull(khachHang) ? khachHang : null;
    }
    public NhanVien checkExistNV(String maNhanVien){
        if(StringUtil.isEmpty(maNhanVien)){
            return null;
        }
        NhanVien nhanVien = nhanVienRepository.findNhanVienByMaNV(maNhanVien);
        return Objects.nonNull(nhanVien) ? nhanVien : null;
    }
    public void saveNhanVien(List<NhanVienImport> nhanVienImports){
        List<NhanVien> listNhanVien = new ArrayList<>();
        if (Objects.nonNull(nhanVienImports) && nhanVienImports.size() > 0) {
            NhanVien nhanVien;
            for(NhanVienImport dto: nhanVienImports){
                dto.setMaNV(this.conCatMa(2,dto.getMaNV()));
                nhanVien = new NhanVien();
                this.modelMapper.map(dto,nhanVien);
                listNhanVien.add(nhanVien);
            }
        }
        nhanVienRepository.saveAll(listNhanVien);
    }
    public void saveDSMenu(List<MenuImport> dsMenuImport) {
        List<Menu> dsMenu = new ArrayList<>();
        if (Objects.nonNull(dsMenuImport) && dsMenuImport.size() > 0) {
            Menu menu;
            for (MenuImport dto : dsMenuImport) {
                if (!StringUtil.isEmpty(dto.toString())) {
                    dto.setMaMon(this.conCatMa(1,dto.getMaMon()));
                    menu = new Menu();
                    this.modelMapper.map(dto, menu);
                    menu.setDonVi("Dia");
                    dsMenu.add(menu);
                }
            }
        }
        menuRepository.saveAll(dsMenu);
    }

    public void saveDSKhachHang(List<KhachHangImport> dsKhachHangImport) {
        List<KhachHang> dsKhachHang = new ArrayList<>();
        if (Objects.nonNull(dsKhachHangImport) && dsKhachHangImport.size() > 0) {
            KhachHang khachHang;
            for (KhachHangImport dto : dsKhachHangImport) {
                if (!StringUtil.isEmpty(dto.toString())) {
                    dto.setMaKH(this.conCatMa(2, dto.getMaKH()));
                    khachHang = new KhachHang();
                    this.modelMapper.map(dto, khachHang);
                    khachHang.setVip(1);
                    dsKhachHang.add(khachHang);
                }
            }
        }
        khachHangRepository.saveAll(dsKhachHang);
    }
    public void saveBan(List<BanImport> dsBanImport) {
        List<Ban> dsBan = new ArrayList<>();
        if (Objects.nonNull(dsBanImport) && dsBanImport.size() > 0) {
            Ban ban;
            for (BanImport banImport : dsBanImport) {
                banImport.setMaBan(banImport.getMaBan());
                ban = new Ban();
                ban.setIDBan(this.conCatIDBan(banImport.getMaBan(), banImport.getSoBan()));
                ban.setSoNguoi(banImport.getSoNguoi());
                ban.setTrangThai(banImport.getTrangThai());
                dsBan.add(ban);
            }
        }
        banRepository.saveAll(dsBan);
    }
    public String conCatIDBan(String maBan, Integer soBan) {
        return maBan.concat(soBan.toString());
    }

    public String conCatMa(Integer startString, String str){
        return StringUtil.isEmpty(str) ? null : str.substring(startString);
    }
}
