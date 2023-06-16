package com.note.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨
 * @version 1.0
 * @since 1.0
 */
public class JsonAndroid implements Serializable {
    private String code; //返回状态
    private String msg; //返回提示信息
    private Object data;//返回的数据

    public JsonAndroid() {
    }

    public JsonAndroid(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonAndroid(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    @Override
    public String toString() {
        Map<String,Object> map = new HashMap<>();
        map.put("code",this.code);
        map.put("msg",this.msg);
        map.put("data",this.data);
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
