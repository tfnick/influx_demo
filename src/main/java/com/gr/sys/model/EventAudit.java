package com.gr.sys.model;

import com.gr.sys.utils.LineProtocalUtils;

import java.util.Date;
import java.util.LinkedHashMap;

//store to db gr_biz
public class EventAudit implements LineProtocolConvert{
    //tag
    String cid;
    String prod_code;
    String etype; // apply or draw
    String advice;// A or B
    //field
    String uid;//md5 of idcard
    Double money; //建议额度或者建议提现金额
    String seq_num;
    Integer accept;//1 or 0
    Integer num = 1;//固定为1，方便在kapacitor中统计通过率，后期切换到flux引擎可以免去这个字段

    Date time;

    @Override
    public String toLineProtocol() {
        String measurement = "m_audit";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        tagKvs.put("cid", cid);
        tagKvs.put("prod_code", prod_code);
        tagKvs.put("etype", etype);
        tagKvs.put("advice", this.advice);

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();


        fieldKvs.put("uid", this.uid);
        fieldKvs.put("money", this.money);
        fieldKvs.put("seq_num", seq_num);
        fieldKvs.put("accept", "accept".equals(this.advice) ? 1 : 0);
        fieldKvs.put("num", 1);

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

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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
