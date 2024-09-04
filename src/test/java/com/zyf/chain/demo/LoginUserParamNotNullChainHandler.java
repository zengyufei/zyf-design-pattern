package com.zyf.chain.demo;

import cn.hutool.core.lang.Console;
import com.zyf.entitys.LoginUser;
import org.springframework.stereotype.Component;

@Component
public final class LoginUserParamNotNullChainHandler implements LoginUserCreateChainFilter<LoginUser> {
    @Override
    public void handler(LoginUser requestParam) {
        Console.log("order: {}, 结果: {}", getOrder(), requestParam.getUserName());
    }
    @Override
    public int getOrder() {
        return 0;
    }
}
