package com.gr.sys.service;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {

        System.out.println(show(1559667600000000000L));
        System.out.println(show(1559669400000000000L));
        System.out.println(show(1559671200000000000L));
        System.out.println(show(1559673000000000000L));
        System.out.println(show(1559784600000000000L));

    }

    public static String show(long time) {

        time = time / 1000000;

        return DateFormatUtils.format(new Date(time),"yyyy-MM-dd HH:mm:ss");

    }
}
