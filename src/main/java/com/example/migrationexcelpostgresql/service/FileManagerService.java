package com.example.migrationexcelpostgresql.service;

import com.example.migrationexcelpostgresql.common.FileUtils;
import com.example.migrationexcelpostgresql.common.StringUtil;
import com.example.migrationexcelpostgresql.dao.KhachHangRepository;
import com.example.migrationexcelpostgresql.dto.ImportData.*;
import com.example.migrationexcelpostgresql.dto.ImportExcelFileDTO;
import com.example.migrationexcelpostgresql.model.KhachHang;
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
    @Autowired ModelMapper modelMapper;

    @Autowired KhachHangRepository khachHangRepository;
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
        List<BanImport> dsBan = Poiji.fromExcel(excelFile, BanImport.class, options);
        List<MenuImport> dsMenu = Poiji.fromExcel(excelFile, MenuImport.class, options);
        List<HoaDonImport> dsHoaDon = Poiji.fromExcel(excelFile, HoaDonImport.class, options);
        excelFile.delete();
    }

    public void saveDSKhachHang(List<KhachHangImport> dsKhachHangImport) {
        List<KhachHang> dsKhachHang = new ArrayList<>();
        if(Objects.nonNull(dsKhachHangImport) && dsKhachHangImport.size() > 0){
            KhachHang khachHang;
            for (KhachHangImport dto: dsKhachHangImport) {
                if(!StringUtil.isEmpty(dto.toString())){
                    khachHang = new KhachHang();
                    this.modelMapper.map(dto, khachHang);
                    khachHang.setVip(1);
                    dsKhachHang.add(khachHang);
                }
            }
        }
        khachHangRepository.saveAll(dsKhachHang);
    }
}
