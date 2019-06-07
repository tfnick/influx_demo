package com.gr.sys.contoller;

import com.gr.sys.utils.LineProtocalUtils;

import java.util.Date;
import java.util.LinkedHashMap;

//store to db gr_biz
public class EventDrawNotify implements LineProtocolConvert{
    //tag
    String cid;
    String prod_code;
    String etype;
    String seq_num;
    //field
    String uid;//md5 of idcard
    Double real_money;// 实际提款金额
    String draw_sts;// 放款结果状态标志 01 03

    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "m_draw_notify";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        tagKvs.put("cid", cid);
        tagKvs.put("prod_code", prod_code);
        tagKvs.put("etype", etype);
        tagKvs.put("seq_num", seq_num);

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("uid", this.uid);
        fieldKvs.put("real_money", this.real_money);
        fieldKvs.put("draw_sts", this.draw_sts);

        return LineProtocalUtils.build(measurement, tagKvs, fieldKvs, this.time);
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getProd_code() {
        return prod_code;
    }

    public void setProd_code(String prod_code) {
        this.prod_code = prod_code;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public String getSeq_num() {
        return seq_num;
    }

    public void setSeq_num(String seq_num) {
        this.seq_num = seq_num;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getReal_money() {
        return real_money;
    }

    public void setReal_money(Double real_money) {
        this.real_money = real_money;
    }

    public String getDraw_sts() {
        return draw_sts;
    }

    public void setDraw_sts(String draw_sts) {
        this.draw_sts = draw_sts;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
