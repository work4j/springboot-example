package com.wor4j.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
    private static final GsonUtil single = new GsonUtil();

    public Gson gson;

    public static GsonUtil getInstance() {
        return single;
    }

    public String toJson(Object o) {
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        String json = gson.toJson(o);
        return json;
    }

    public Object fromJson(String json, Class<?> clazz) {
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Object o = gson.fromJson(json, clazz);
        return o;
    }


}
