package com.zyf;

import com.zyf.designPattern.chain.AbstractChainContext;
import com.zyf.entitys.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {
        "com.zyf",
})
@SpringBootTest(classes = TestChain.class)
//@RunWith(SpringRunner.class)
public class TestChain {

    @Autowired
    private AbstractChainContext<LoginUser> abstractChainContext;

    @Test
    public void test() {
        final LoginUser loginUser = new LoginUser();
        loginUser.setUserName("aaaaa");
        abstractChainContext.handler(LoginUser.class.getSimpleName(), loginUser);
    }

}
