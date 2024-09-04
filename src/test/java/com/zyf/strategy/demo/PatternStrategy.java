package com.zyf.strategy.demo;

import cn.hutool.core.lang.Console;
import com.zyf.designPattern.strategy.AbstractExecuteStrategy;
import com.zyf.entitys.LoginUser;
import org.springframework.stereotype.Component;

@Component
public class PatternStrategy implements AbstractExecuteStrategy<LoginUser, Boolean> {

    /**
     * 执行策略范匹配标识
     */
    @Override
    public String patternMatchMark() {
        return "^0752.*$";
    }

    @Override
    public void execute(LoginUser param) {
        Console.log("标识: {}, 结果: 正则", patternMatchMark());
    }
}
