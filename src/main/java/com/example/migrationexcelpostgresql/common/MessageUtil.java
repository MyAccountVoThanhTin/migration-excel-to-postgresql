package com.example.migrationexcelpostgresql.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageUtil {

    /** MessageSource */
    @Autowired
    MessageSource msgSource;

    /**
     * Get message from message code
     *
     * @param messageCode
     * @return message
     */
    public String getMessage(String messageCode) {
        String retMessage = StringUtil.EMPTY;

        if (StringUtil.isEmpty(messageCode)) {
            return retMessage;
        }

        try {
            retMessage = this.msgSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            retMessage = messageCode;
        }
        return retMessage;
    }
}
