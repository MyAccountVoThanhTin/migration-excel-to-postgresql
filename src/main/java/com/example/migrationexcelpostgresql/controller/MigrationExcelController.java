package com.example.migrationexcelpostgresql.controller;

import com.example.migrationexcelpostgresql.common.ResponseEntityUtil;
import com.example.migrationexcelpostgresql.common.StringUtil;
import com.example.migrationexcelpostgresql.dto.ImportExcelFileDTO;
import com.example.migrationexcelpostgresql.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MigrationExcelController {

    @Autowired
    FileManagerService fileManagerService;

    @Autowired
    ResponseEntityUtil responseEntityUtil;

    @PostMapping("files/import-excel-data")
    public ResponseEntity<Object> importExcelData(
            @RequestBody ImportExcelFileDTO importExcelFileDTO) {
        this.fileManagerService.importExcelData(importExcelFileDTO);
        return this.responseEntityUtil.generateResponse(HttpStatus.OK, StringUtil.UPDATE_SUCCESSFUL_MSG);
    }
}