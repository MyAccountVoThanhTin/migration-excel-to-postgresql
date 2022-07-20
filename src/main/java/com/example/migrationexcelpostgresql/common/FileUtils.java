package com.example.migrationexcelpostgresql.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Objects;

public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static File convertBase64ToFile(String outputFileName, String base64String) {
        File file = null;
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            if (Objects.isNull(outputFileName)) {
                file = File.createTempFile("uploadFileToS3_", StringUtil.EMPTY);
            } else {
                file = new File(outputFileName);
            }
            writeByte(decodedBytes, file);
        } catch (IOException e) {
            logger.error("Can not convert base64 to file:" + e);
        }
        return file;
    }

    public static void writeByte(byte[] bytes, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
