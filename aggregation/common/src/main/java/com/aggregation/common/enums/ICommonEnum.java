package com.aggregation.common.enums;

import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.Objects;

/**
 * @Desc 公共枚举类
 * 没用泛型的原因是 静态方法上不能使用泛型
 * 其实这个类更像是一个工具类
 */
public interface ICommonEnum {

    /**
     * @Desc getCode
     */
    <T> T getCode();

    /**
     * @Desc getDesc
     */
    <T> T getDesc();

    /**
     * @Desc 根据code查询
     */
    static <T extends Enum<T> & ICommonEnum, K> T getByCode(Class<T> clazz, K code) {
        EnumSet<T> all = EnumSet.allOf(clazz);
        return all.stream().filter(e -> Objects.equals(e.getCode(), code)).findFirst().orElse(null);
    }

    /**
     * @Desc 根据code查desc
     */
    static <T extends Enum<T> & ICommonEnum, K> String getDescByCode(Class<T> clazz, K code) {
        T enumImpl = getByCode(clazz, code);
        return Objects.nonNull(enumImpl) ? enumImpl.getDesc().toString() : null;
    }


}
