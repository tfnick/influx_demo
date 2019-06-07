package com.gr.sys.contoller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gr.common.utils.JacksonUtil;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("metric")
public class BizMetricController {

    private static Logger logger = LoggerFactory.getLogger("daily_task");

    @RequestMapping("/pboc_task/query")
    public String query(){

        PbocQueryTaskMetric metric = new PbocQueryTaskMetric();

        metric.setRunning_tasks(RandomUtils.nextInt(50, 600));

        metric.setTime(new Date());

        System.out.println(metric.toLineProtocol());

        return metric.toLineProtocol();
    }


    @RequestMapping("/daily_task/execute")
    public String execute(){

        DailyFileSyncTaskMetric metric = new DailyFileSyncTaskMetric();

        metric.setTask_name("zy_daily_sync");

        metric.setTime(new Date());

        metric.setError_file_name(null);

        metric.setFile_num(5);

        metric.setTask_status("1");//1 完成 0 全部失败 2 部分失败

        logger.info(metric.toLineProtocol());

        return metric.toLineProtocol();
    }
}
