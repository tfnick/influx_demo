package com.gr.sys.model;

import com.gr.sys.utils.LineProtocalUtils;
import java.util.Date;
import java.util.LinkedHashMap;


/**
 * 日终文件同步监控指标 - store to db gr_biz
 */
public class EventDailyFileSync implements LineProtocolConvert{

    //tag
    String task_name;

    //field
    //运行时间
    Long rt;
    Integer file_num;
    /*文件内容有误或者不完整的文件名，多个以|分割*/
    String error_file_name;
    /*全部成功 失败 部分成功*/
    String task_status;


    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "m_daily_file_sync";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        tagKvs.put("task_name", this.task_name);

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("file_num", this.file_num);
        fieldKvs.put("rt", this.rt);
        fieldKvs.put("error_file_name", this.error_file_name);
        fieldKvs.put("task_status", this.task_status);

        return LineProtocalUtils.build(measurement, tagKvs, fieldKvs, this.time);
    }


    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public int getFile_num() {
        return file_num;
    }

    public void setFile_num(int file_num) {
        this.file_num = file_num;
    }

    public String getError_file_name() {
        return error_file_name;
    }

    public void setError_file_name(String error_file_name) {
        this.error_file_name = error_file_name;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getRt() {
        return rt;
    }

    public void setRt(long rt) {
        this.rt = rt;
    }
}
