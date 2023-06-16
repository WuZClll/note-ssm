package com.note.utils;

import java.lang.reflect.Field;

/**
 *   把实体类的空字符'' 转换未null
 */
public class ConversionStrUtil {
    public static Object ConversionStr(Object o) {
        for (Field declaredField : o.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            try {
                Object value = declaredField.get(o);
                if ("".equals(value)) {
                    declaredField.set(o, null);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return o;
    }
}
