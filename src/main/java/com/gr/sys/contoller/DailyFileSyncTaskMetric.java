package com.gr.sys.contoller;

import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 日终文件同步监控指标
 */
@Data
public class DailyFileSyncTaskMetric implements LineProtocolConvert{
    String task_name;
    int file_num;
    /*文件内容有误或者不完整的文件名，多个以|分割*/
    String error_file_name;
    String task_status;
    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "daily_task_sts";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        tagKvs.put("task_name", this.getTask_name());

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("file_num", this.getFile_num());
        fieldKvs.put("error_file_name", this.getError_file_name());
        fieldKvs.put("task_status", this.getTask_status());

        return LineProtocalUtils.build(measurement, tagKvs, fieldKvs, this.time);
    }
}
