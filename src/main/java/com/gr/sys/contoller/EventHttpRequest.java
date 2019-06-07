package com.gr.sys.contoller;

import com.gr.sys.utils.LineProtocalUtils;

import java.util.Date;
import java.util.LinkedHashMap;

// store to db gr_app
public class EventHttpRequest implements LineProtocolConvert{
    //tag
    String cid;
    String invoker;//the service invoker such as approve,entry,engine etc
    String url;

    //field
    String gid;
    int rt;//response time cost
    String code;
    String http_sts;

    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "m_http_service";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        tagKvs.put("cid", cid);
        tagKvs.put("invoker", invoker);
        tagKvs.put("url", url);

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("gid", this.gid);
        fieldKvs.put("rt", this.rt);
        fieldKvs.put("code", this.code);
        fieldKvs.put("http_sts", this.http_sts);

        return LineProtocalUtils.build(measurement, tagKvs, fieldKvs, this.time);
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHttp_sts() {
        return http_sts;
    }

    public void setHttp_sts(String http_sts) {
        this.http_sts = http_sts;
    }

    public String getInvoker() {
        return invoker;
    }

    public void setInvoker(String invoker) {
        this.invoker = invoker;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
