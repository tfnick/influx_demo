package com.gr.sys.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class LineProtocalUtils {

    public static String build(String measure, LinkedHashMap<String,Object> tags, LinkedHashMap<String,Object> fields, Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        if (StringUtils.isEmpty(measure)) {//ignore
            return null;
        }else{
            stringBuffer.append(measure);
        }
        if (tags != null && tags.size() > 0) {
            stringBuffer.append(",");

            for (Map.Entry<String, Object> entry : tags.entrySet()) {
                stringBuffer.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
            }

            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (fields == null || fields.isEmpty()) {//ignore
            return null;
        }else{
            stringBuffer.append(" ");
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                if (entry.getValue() != null) {
                    String val = entry.getValue() instanceof String ? "\"" + entry.getValue() + "\"" : "" + entry.getValue();
                    stringBuffer.append(entry.getKey()).append("=").append(val).append(",");
                }
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

        if (date == null) {
            date = new Date();
        }

        stringBuffer.append(" ").append(date.getTime() * 1000000);//转为纳秒

        return stringBuffer.toString();
    }
}
