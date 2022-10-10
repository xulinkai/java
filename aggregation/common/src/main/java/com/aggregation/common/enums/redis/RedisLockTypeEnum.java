package com.aggregation.common.enums.redis;

import com.aggregation.common.enums.ICommonEnum;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RedisLockTypeEnum implements ICommonEnum {


    ONE("business_1", "test_1"),
    TWO("business_2", "test_2"),
    ;


    private String code;

    private String desc;


    public String getUniqueKey(String key) {
        return String.format("%s:%s", this.getCode(), key);
    }

    public static void main(String[] args) {
        RedisLockTypeEnum business_1 = ICommonEnum.getByCode(RedisLockTypeEnum.class, "business_1");
        System.out.println(JSONObject.toJSONString(business_1));

        String business_11 = ICommonEnum.getDescByCode(RedisLockTypeEnum.class, "business_1");
        System.out.println(business_11);

    }



}
