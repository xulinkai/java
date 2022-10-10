package com.aggregation.secret.controller;

import com.aggregation.secret.base.SecretResult;
import com.aggregation.secret.constants.SecretConstant;
import com.aggregation.secret.enums.UserType;
import com.aggregation.secret.model.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: 用户控制器类
 */
@Slf4j
@RestController
@RequestMapping(value = {"/user", SecretConstant.PREFIX + "/user"})
public class UserController {

    @RequestMapping("/list")
    public SecretResult<List<User>> listUser(@RequestBody User user) {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setId(1);
        u.setName("xlk");
        u.setRegisterTime(LocalDateTime.now());
        u.setUserType(UserType.COMMON);
        users.add(u);
        SecretResult<List<User>> response = new SecretResult<>();
        response.setCode(200);
        response.setData(users);
        response.setMsg("用户列表查询成功");
        return response;
    }

    @RequestMapping("/save")
    public SecretResult<Boolean> saveUser(@RequestBody User user) {
        // ... 新建用户
        log.info("save user ok: {}", JSON.toJSON(user));
        SecretResult<Boolean> response = new SecretResult<>();
        response.setCode(200);
        response.setData(Boolean.TRUE);
        response.setMsg("用户创建成功");
        return response;
    }
}
