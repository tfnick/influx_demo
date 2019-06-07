package com.gr.sys.contoller;

import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

import com.gr.sys.utils.LineProtocalUtils;

/**
 * 征信报告查询监控指标 store to db gr_app
 */
@Data
public class MetricRunningTask implements LineProtocolConvert {

    //no tag

    //field
    // 当前xxl-job中运行的任务数
    int pboc_num = 0;


    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "m_running_task";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("pboc_num", this.pboc_num);

        return LineProtocalUtils.build(measurement, tagKvs, fieldKvs, this.time);
    }

    public int getPboc_num() {
        return pboc_num;
    }

    public void setPboc_num(int pboc_num) {
        this.pboc_num = pboc_num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
