package com.gr.sys.contoller;

import com.gr.sys.utils.LineProtocalUtils;

import java.util.Date;
import java.util.LinkedHashMap;

//store to db gr_biz
public class EventRuleHit implements LineProtocolConvert{
    //tag
    String cid;
    String prod_code;
    String etype;
    String seq_num;
    //field
    String rule_set;
    String rule;

    Date time;


    @Override
    public String toLineProtocol() {

        String measurement = "m_rule_hit";

        LinkedHashMap<String, Object> tagKvs = new LinkedHashMap<>();

        tagKvs.put("cid", cid);
        tagKvs.put("prod_code", prod_code);
        tagKvs.put("etype", etype);
        tagKvs.put("seq_num", seq_num);

        LinkedHashMap<String, Object> fieldKvs = new LinkedHashMap<>();

        fieldKvs.put("rule_set", this.rule_set);
        fieldKvs.put("rule", this.rule);

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

    public String getSeq_num() {
        return seq_num;
    }

    public void setSeq_num(String seq_num) {
        this.seq_num = seq_num;
    }

    public String getRule_set() {
        return rule_set;
    }

    public void setRule_set(String rule_set) {
        this.rule_set = rule_set;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }
}
