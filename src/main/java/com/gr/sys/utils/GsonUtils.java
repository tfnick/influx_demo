package com.gr.sys.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonUtils {

    // default date formate is Jun 7, 2019 10:13:27 AM
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static String toJson(Object bean) {
        return gson.toJson(bean);
    }

    public static <T> T toBean(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    public static <T> T toBean(String json, TypeToken<T> token) {
        return gson.fromJson(json, token.getType());

    }

    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("x1", 1);
        data.put("x2", new Date());// Jun 7, 2019 10:13:27 AM
        data.put("x3", true);
        data.put("x4", 1000000000008989L);
        data.put("x5", 6.45f);

        System.out.println(GsonUtils.toJson(data));
    }

}
