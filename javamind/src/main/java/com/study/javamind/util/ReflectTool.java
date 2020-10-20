package com.study.javamind.util;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java 反射工具类
 * 
 * @author liuzhongqi
 * @date: 2016年12月16日 上午11:16:20
 * @version 1.0
 * @since JDK 1.7
 */
public class ReflectTool
{
    private Boolean isMap = false;
    private Map<String, Field> fields = null;

    public ReflectTool(Object o, List<String> fieldNames) throws NoSuchFieldException {
        if (o instanceof Map) {
            isMap = true;
            return;
        }
        fields = new HashMap<>(fieldNames.size());
        Field f;
        Class<?> cls = o.getClass();
        for (Object fieldName : fieldNames) {
            f = getMethod(cls, fieldName);
            if (f == null) {
                throw new NoSuchFieldException("类" + cls.getName() + "找不到属性" + fieldName);
            }
            fields.put(fieldName.toString(), f);
        }
    }
    
    /**
     * 获取某个类的某个字段 支持查找父类，并且打开访问权限
     * 
     * @author liuzhongqi
     * @date: 2016年12月16日 上午11:16:34
     * @version 1.0
     *
     * @param cls
     * @param fieldName
     * @return
     * @throws NoSuchFieldException
     */
    public static Field getField(Class<?> cls, String fieldName) throws NoSuchFieldException {
        Field f = null;
        Class<?> clazz = cls;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                f = clazz.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        throw new NoSuchFieldException("类" + cls.getName() + "找不到属性" + fieldName);
    }

    private Field getMethod(Class<?> cls, Object fieldName) {
        Field f = null;
        for (Class<?> clazz = cls; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                f = clazz.getDeclaredField(fieldName.toString());
                f.setAccessible(true);
                break;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return f;
    }

    public Object get(Object o, String fieldName) throws Exception {
        if (isMap) {
            return ((Map<?, ?>) o).get(fieldName);
        } else {
            try {
                return fields.get(fieldName).get(o);
            } catch (Exception e) {
                System.out.println(e);
                throw new Exception(e.getMessage());
            }
        }
    }
}