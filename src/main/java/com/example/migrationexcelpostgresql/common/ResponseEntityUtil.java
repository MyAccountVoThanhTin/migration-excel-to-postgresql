package com.example.migrationexcelpostgresql.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@Slf4j
public class ResponseEntityUtil {
    @Autowired
    MessageUtil messageUtil;
    private enum RESPONSE_PROPERTIES {
        TIMESTAMP("timestamp"),
        STATUS("status"),
        MESSAGES("messages");

        String value;

        RESPONSE_PROPERTIES(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public ResponseEntity<Object> generateResponse(HttpStatus status, String messageCode) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(RESPONSE_PROPERTIES.TIMESTAMP.getValue(), new Date());
        body.put(RESPONSE_PROPERTIES.STATUS.getValue(), status.value());

        // get message by message code
        String msg = this.messageUtil.getMessage(messageCode);
        body.put(RESPONSE_PROPERTIES.MESSAGES.getValue(), msg);
        return new ResponseEntity<>(body, status);
    }
}
