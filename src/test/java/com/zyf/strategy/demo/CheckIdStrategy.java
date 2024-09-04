package com.zyf.strategy.demo;

import cn.hutool.core.lang.Console;
import com.zyf.designPattern.strategy.AbstractExecuteStrategy;
import com.zyf.entitys.LoginUser;
import org.springframework.stereotype.Component;

@Component
public class CheckIdStrategy implements AbstractExecuteStrategy<LoginUser, Boolean> {

    @Override
    public String mark() {
        return "checkId";
    }

    @Override
    public void execute(LoginUser param) {
        Console.log("标识: {}, 结果: {}", mark(), param.getUserId());
    }
}
