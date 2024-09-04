package com.zyf.strategy.demo;

import cn.hutool.core.lang.Console;
import com.zyf.designPattern.strategy.AbstractExecuteStrategy;
import com.zyf.entitys.LoginUser;
import org.springframework.stereotype.Component;

@Component
public class ErrorStrategy implements AbstractExecuteStrategy<LoginUser, Boolean> {

    @Override
    public String mark() {
        return "error";
    }

    @Override
    public void execute(LoginUser param) {
        throw new RuntimeException("主动抛出异常");
    }
}
