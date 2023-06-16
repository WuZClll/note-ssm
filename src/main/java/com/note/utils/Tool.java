package com.note.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {
    public static String SerialNumber(){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = f.format(new Date(System.currentTimeMillis()));
        return date;
    }
    public static String setHengName(String xiangmuno){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = f.format(new Date(System.currentTimeMillis()));
        String name = xiangmuno + "h" + date + ".jpg";
        return name;
    }
    public static String setShuName(String xiangmuno){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = f.format(new Date(System.currentTimeMillis()));
        String name = xiangmuno + "s" + date + ".jpg";
        return name;
    }
}
