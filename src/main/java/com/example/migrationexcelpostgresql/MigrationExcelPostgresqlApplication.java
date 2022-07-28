package com.example.migrationexcelpostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages="com.example.migrationexcelpostgresql")
@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.example.migrationexcelpostgresql.model"})
public class MigrationExcelPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigrationExcelPostgresqlApplication.class, args);
    }

}
