package com.study.javamind.util;

import com.study.javamind.exception.BizException;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zou_xq
 * @description:
 * @date: 2020/10/20 17:36
 */
public class MapTool {
    private static final Logger logger = LoggerFactory.getLogger(MapTool.class);

    /**
     * get a HashMap<keyType,valueType>
     *
     * @author liuzhongqi
     * @date: 2016年10月28日 下午3:00:43
     * @version 1.0
     *
     * @param keyType
     * @param valueType
     * @param params
     * @return
     */
    public static <K, V> Map<K, V> getMap(Class<K> keyType, Class<V> valueType, Object... params) {
        Map<K, V> map = new HashMap<>();
        if (params == null) {
            return map;
        }
        for (int n = 0; n < params.length / 2; n++) {
            map.put(keyType.cast(params[2 * n]), valueType.cast(params[2 * n + 1]));
        }
        return map;
    }

    /**
     * get a HashMap<String,Object>
     *
     * @author liuzhongqi
     * @date: 2016年10月28日 下午3:00:27
     * @version 1.0
     *
     * @param params
     * @return
     */
    public static Map<String, Object> getSOMap(Object... params) {
        Map<String, Object> map = new HashMap<>();
        if (params == null) {
            return map;
        }
        for (int n = 0; n < params.length / 2; n++) {
            map.put(String.class.cast(params[2 * n]), params[2 * n + 1]);
        }
        return map;
    }

    /**
     * get a HashMap<String,String>
     *
     * @author liuzhongqi
     * @date: 2016年10月28日 下午2:59:47
     * @version 1.0
     *
     * @param params
     * @return
     */
    public static Map<String, String> getSSMap(Object... params) {
        Map<String, String> map = new HashMap<>();
        if (params == null) {
            return map;
        }
        for (int n = 0; n < params.length / 2; n++) {
            map.put((String) (params[2 * n]), (String) params[2 * n + 1]);
        }
        return map;
    }

    /**
     * 将入参拼接成放入一个LinkedMap<keyType,valueType>中，奇数位参数为key，偶数位为值
     *
     * @param params
     * @return
     */
    public static <K, V> Map<K, V> getLinkedMap(Class<K> keyType, Class<V> valueType, Object... params) {
        Map<K, V> result = new LinkedHashMap<>();
        if (params == null) {
            return result;
        }
        for (int n = 0; n < params.length / 2; n++) {
            result.put(keyType.cast(params[2 * n]), valueType.cast(params[2 * n + 1]));
        }
        return result;
    }

    /**
     * 将一个数组对象转换成一个Map，对象必须是javaBean，不能是map
     * @author liuzhongqi
     * @date: 2016年12月16日 上午11:27:31
     * @version 1.0
     *
     * @param keyType
     * @param keyName
     * @param valueType
     * @param valueName
     * @param list
     * @return
     * @throws RuntimeException
     */
    public static <K, V> Map<K, V> listObjToMap(List<?> list, Class<?> dataType,
                                                Class<K> keyType, String keyName, Class<V> valueType, String valueName) {
        Map<K, V> resultMap = new HashMap<>();
        if(list==null || !list.isEmpty()) {
            return resultMap;
        }
        try {
            Field keyF = ReflectTool.getField(dataType, keyName);
            Field valueF = ReflectTool.getField(dataType, valueName);
            for(Object obj : list) {
                resultMap.put(keyType.cast(keyF.get(obj)), valueType.cast(valueF.get(obj)));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BizException(e.getMessage());
        }
        return resultMap;
    }

    /**
     * 将一个数组对象转换成一个Map，对象必须是javaBean，对象是map
     * @author liuzhongqi
     * @date: 2016年12月16日 上午11:27:31
     * @version 1.0
     *
     * @param keyType
     * @param keyName
     * @param valueType
     * @param valueName
     * @param list
     * @return
     * @throws RuntimeException
     */
    public static <K, V> Map<K, V> listMapToMap(List<Map<?,?>> list,
                                                Class<K> keyType, String keyName, Class<V> valueType, String valueName) {
        Map<K, V> resultMap = new HashMap<>();
        if(list==null || !list.isEmpty()) {
            return resultMap;
        }
        try {
            for(Map<?,?> obj : list) {
                resultMap.put(keyType.cast(obj.get(keyName)), valueType.cast(obj.get(valueName)));
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BizException(e.getMessage());
        }
        return resultMap;
    }

    //将javabean实体类转为map类型，然后返回一个map类型的值
    public static Map<String, Object> beanToMap(Object obj) {
        if(obj == null){
            return null;
        }
        Map<String, Object> params = new HashMap<>();
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            if(logger.isTraceEnabled()) {
                logger.trace(e.getMessage(), e);
            }
        }
        return params;
    }
}
