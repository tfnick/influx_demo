package com.gr.sys;

import com.gr.sys.contoller.EventDailyFileSync;
import com.gr.sys.contoller.MetricRunningTask;
import org.junit.Test;

import java.util.Date;

public class LineProtocalTest {

    @Test
    public void testPboc(){
        MetricRunningTask pboc = new MetricRunningTask();

        pboc.setTime(new Date());
        pboc.setPboc_num(10);

        System.out.println(pboc.toLineProtocol());
    }

    //EventDailyFileSync

    @Test
    public void testDaily(){
        EventDailyFileSync daily = new EventDailyFileSync();

        daily.setTime(new Date());
        daily.setError_file_name(null);
        daily.setTask_status("1");
        daily.setFile_num(5);
        daily.setTask_name("zy_daily_sync");

        System.out.println(daily.toLineProtocol());
    }
}
