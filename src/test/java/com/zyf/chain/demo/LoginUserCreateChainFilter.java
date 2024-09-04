package com.zyf.chain.demo;


import com.zyf.designPattern.chain.AbstractChainHandler;
import com.zyf.entitys.LoginUser;

/**
 * 用户注册责任链过滤器
 */
public interface LoginUserCreateChainFilter<T extends LoginUser> extends AbstractChainHandler<LoginUser> {

    @Override
    default String mark() {
        return LoginUser.class.getSimpleName();
    }
}
