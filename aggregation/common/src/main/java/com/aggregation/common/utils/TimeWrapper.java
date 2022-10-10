package com.aggregation.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Desc
 */
@Slf4j
public class TimeWrapper {

    public static final String DAY_TIME_END = "23:59:59";

    public static final String DAY_TIME_START = "00:00:00";

    public static final String BLANK_SPACE = " ";

    /**
     * @Desc 开始日期拼接上 DAY_TIME_START, 结束日期拼接上 DAY_TIME_END
     */
    public static <T> void wrapStartAndEnd(T obj, List<String> startFields, List<String> endFields) {
        wrapStart(obj, startFields);
        wrapEnd(obj, endFields);
    }


    public static <T> void wrapStart(T obj, List<String> startFields) {
        doWrapTime(obj, DAY_TIME_START, startFields);
    }

    public static <T> void wrapEnd(T obj, List<String> endFields) {
        doWrapTime(obj, DAY_TIME_END, endFields);
    }

    public static <T> void doWrapTime(T obj, String suffix, List<String> fields) {
        try {
            Map<String, Field> fieldMap = PracticeBeanUtils.getFieldMap(obj);

            for (String field : fields) {

                Field curField = fieldMap.get(field);
                if (Objects.isNull(curField)) {
                    continue;
                }

                curField.setAccessible(true);
                Object fieldValue = curField.get(obj);
                if (Objects.isNull(fieldValue) || StringUtils.isBlank(String.valueOf(fieldValue))) {
                    continue;
                }

                curField.set(obj, fieldValue + BLANK_SPACE + suffix);
            }
        } catch (Exception e) {
            log.error("wrapTime error", e);
        }
    }
}
