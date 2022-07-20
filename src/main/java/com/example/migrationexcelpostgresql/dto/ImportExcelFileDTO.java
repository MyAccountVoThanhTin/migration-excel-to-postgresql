package com.example.migrationexcelpostgresql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImportExcelFileDTO {
    private String fileName;
    private String fileContent;
}
