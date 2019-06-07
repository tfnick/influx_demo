package com.gr.sys;

import com.gr.sys.contoller.DailyFileSyncTaskMetric;
import com.gr.sys.contoller.PbocQueryTaskMetric;
import org.junit.Test;

import java.util.Date;

public class LineProtocalTest {

    @Test
    public void testPboc(){
        PbocQueryTaskMetric pboc = new PbocQueryTaskMetric();

        pboc.setTime(new Date());
        pboc.setRunning_tasks(10);

        System.out.println(pboc.toLineProtocol());
    }

    //DailyFileSyncTaskMetric

    @Test
    public void testDaily(){
        DailyFileSyncTaskMetric daily = new DailyFileSyncTaskMetric();

        daily.setTime(new Date());
        daily.setError_file_name(null);
        daily.setTask_status("1");
        daily.setFile_num(5);
        daily.setTask_name("zy_daily_sync");

        System.out.println(daily.toLineProtocol());
    }
}
