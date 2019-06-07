package com.gr.sys.contoller;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 征信报告查询监控指标
 */
@Data
public class PbocQueryTaskMetric implements LineProtocolConvert{
    //当前xxl-job中运行的任务数
    int running_tasks = 0;
    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "pboc_task_sts";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("running_tasks", this.running_tasks);

        return LineProtocalUtils.build(measurement, tagKvs, fieldKvs, this.time);
    }

}
