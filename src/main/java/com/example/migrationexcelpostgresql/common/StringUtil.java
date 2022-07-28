package com.example.migrationexcelpostgresql.common;

import java.util.Objects;

public class StringUtil {
    public static final String EMPTY = "";

    public static final String UPDATE_SUCCESSFUL_MSG = "update.successful";

    public static boolean isEmpty(String strValue) {
        return Objects.isNull(strValue) || StringUtil.EMPTY.equals(strValue.trim());
    }

    public static Integer convertSex(String nameSex){
        return nameSex.equals("Nam") ?  0 : 1;
    }
}