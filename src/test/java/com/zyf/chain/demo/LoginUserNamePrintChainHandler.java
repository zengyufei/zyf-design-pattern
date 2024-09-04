package com.zyf.chain.demo;

import cn.hutool.core.util.StrUtil;
import com.zyf.entitys.LoginUser;
import org.springframework.stereotype.Component;

@Component
public final class LoginUserNamePrintChainHandler implements LoginUserCreateChainFilter<LoginUser> {
    @Override
    public void handler(LoginUser requestParam) {
        if (StrUtil.isBlank(requestParam.getUserId())) {
            throw new RuntimeException(
                    StrUtil.format("order: {}, 结果: 用户id不能为空!", getOrder()));
        }
    }
    @Override
    public int getOrder() {
        return 1;
    }
}
