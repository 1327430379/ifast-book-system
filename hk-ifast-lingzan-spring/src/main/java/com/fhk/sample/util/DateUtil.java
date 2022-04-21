package com.fhk.sample.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static boolean isSameDay(Date d1, Date d2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(d1).equals(sdf.format(d2));
    }
}
