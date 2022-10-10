package com.aggregation.basic.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Desc
 */
public class JsonTest {


    /**
     * jackson注解，springmvc采用此种方式序列化，前后端交互或者接口调用时，需要加此注解
     * timezone不加此属性的话 得到的时间会往前推8小时
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * fastjson注解，fastJson序列化时生效
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
