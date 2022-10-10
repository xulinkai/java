package com.aggregation.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @created by xlk on 2022/7/20 11:39
 */
public class PracticeBeanUtils {


    /**
     * @Desc 类型转换
     */
    public static <T, E> List<T> convert(List<E> sourceList, Class<T> clazz){
        if(CollectionUtils.isEmpty(sourceList)){
            return null;
        }
        return JSONObject.parseArray(JSONObject.toJSONString(sourceList), clazz);
    }


    /**
     * @Desc fieldMap
     */
    public static <T> Map<String, Field> getFieldMap(T t) {
        Field[] fields = FieldUtils.getAllFields(t.getClass());
        Map<String, Field> fieldMap = Maps.newHashMap();
        for (Field field : fields) {
            fieldMap.put(field.getName(), field);
        }
        return fieldMap;
    }

}
