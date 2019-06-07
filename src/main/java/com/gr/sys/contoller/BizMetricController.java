package com.gr.sys.contoller;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BizMetricController {

    private static Logger logger = LoggerFactory.getLogger("daily_task");

    /*******************http input*********************/
    /**
     * 提供指标查询接口供telegraf定时获取
     * @return
     */
    @RequestMapping("/metric/pboc_task/query")
    public String query() {

        MetricRunningTask metric = new MetricRunningTask();

        metric.setPboc_num(RandomUtils.nextInt(50, 600));

        metric.setTime(new Date());

        System.out.println(metric.toLineProtocol());

        return metric.toLineProtocol();
    }

    /*******************file input*********************/
    /**
     * 写入事件日志供telegraf实时拉取
     * @return
     */
    @RequestMapping("/event/daily_task/trigger")
    public String execute() {

        EventDailyFileSync metric = new EventDailyFileSync();

        metric.setTask_name("zy_daily_sync");

        metric.setTime(new Date());

        metric.setError_file_name(null);

        metric.setFile_num(5);

        metric.setTask_status("1");// 1 完成 0 全部失败 2 部分失败

        logger.info(metric.toLineProtocol());

        return metric.toLineProtocol();
    }
}
