package com.example.migrationexcelpostgresql.service;

import com.example.migrationexcelpostgresql.common.FileUtils;
import com.example.migrationexcelpostgresql.dto.ImportExcelFileDTO;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
@Slf4j
public class FileManagerService {

    @Transactional
    public void importExcelData(ImportExcelFileDTO importExcelFileDTO) {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder
                .settings(1)
                .headerStart(2)
                .caseInsensitive(false)
                .ignoreWhitespaces(true)
                .trimCellValue(true)
                .build();
        File excelFile =
                FileUtils.convertBase64ToFile(
                        importExcelFileDTO.getFileName(), importExcelFileDTO.getFileContent());
//        List<ShukuhakuDTOImport> listShukuhaku = Poiji.fromExcel(excelFile, ShukuhakuDTOImport.class, options);
//        List<CompanyDTOImport> listCompany = Poiji.fromExcel(excelFile, CompanyDTOImport.class, options);
//        List<SitenDTOImport> listSiten = Poiji.fromExcel(excelFile, SitenDTOImport.class, options);

//    PoijiOptions optionMembers = PoijiOptions.PoijiOptionsBuilder
//            .settings()
//            .headerStart(5)
//            .caseInsensitive(false)
//            .ignoreWhitespaces(true)
//            .trimCellValue(true)
//            .build();
//    List<MainMemberDTOImport> listMember = Poiji.fromExcel(excelFile, MainMemberDTOImport.class, optionMembers);
        excelFile.delete();
    }
}
