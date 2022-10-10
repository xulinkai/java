package com.aggregation.common.utils;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc 正则替换目标字符串
 */
@Slf4j
public class RenderUtil {

    /**
     * @Desc ${}
     */
    private static final String REGEX_EXTENSION = "\\$\\{(.+?)\\}";

    /**
     * @Desc #{}
     */
    private static final String REGEX_DEFAULT = "\\#\\{(.+?)\\}";


    /**
     * @Desc 替换字符换中的 ${property}
     */
    public static <T> String render(String template, T t) {
        return render(template, t, REGEX_DEFAULT);
    }


    /**
     * @Desc 正则替换字符串中的特殊字符
     */
    public static <T> String render(String template, T object, String regex) {
        if (StringUtils.isBlank(regex) || StringUtils.isBlank(template) || Objects.isNull(object)) {
            return template;
        }
        return doRender(template, object, regex);
    }

    /**
     * @Desc doRender
     */
    private static <T> String doRender(String template, T object, String regex) {
        try {
            Map<String, Field> fieldMap = getFieldMap(object);
            StringBuffer stringBuffer = new StringBuffer();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(template);
            while (matcher.find()) {
                String key = matcher.group(1);
                Field field = fieldMap.get(key);
                field.setAccessible(true);
                String value = Objects.equals(field.getType(), Date.class) ? DateUtils.dayFormat(((Date) field.get(object))) : String.valueOf(field.get(object));
                matcher.appendReplacement(stringBuffer, value);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (Exception e) {
            log.error("替换字符串特殊字符出现异常", e);
        }
        return template;
    }

    /**
     * @Desc fieldMap
     */
    private static <T> Map<String, Field> getFieldMap(T t) {
        Field[] fields = FieldUtils.getAllFields(t.getClass());
        Map<String, Field> fieldMap = Maps.newHashMap();
        for (Field field : fields) {
            fieldMap.put(field.getName(), field);
        }
        return fieldMap;
    }


}
