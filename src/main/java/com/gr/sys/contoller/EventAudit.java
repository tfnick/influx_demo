package com.gr.sys.contoller;

import com.gr.sys.utils.LineProtocalUtils;

import java.util.Date;
import java.util.LinkedHashMap;

//store to db gr_biz
public class EventAudit implements LineProtocolConvert{
    //tag
    String cid;
    String prod_code;
    String etype; // apply or draw
    String seq_num;
    //field
    String sn;
    String uid;//md5 of idcard
    Double money; //建议额度或者建议提现金额
    String advice;// A or B

    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "m_audit";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        tagKvs.put("cid", cid);
        tagKvs.put("prod_code", prod_code);
        tagKvs.put("etype", etype);
        tagKvs.put("seq_num", seq_num);

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("sn", this.sn);
        fieldKvs.put("uid", this.uid);
        fieldKvs.put("money", this.money);
        fieldKvs.put("advice", this.advice);

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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
