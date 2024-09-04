package com.zyf;

import com.zyf.designPattern.strategy.AbstractStrategyChoose;
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
@SpringBootTest(classes = TestStrategy.class)
//@RunWith(SpringRunner.class)
public class TestStrategy {

    @Autowired
    AbstractStrategyChoose abstractStrategyChoose;

    @Test
    public void test() {
        final LoginUser loginUser = new LoginUser();
        loginUser.setUserName("aaaaa");

        // 指定名 checkId 策略：打印id
        abstractStrategyChoose.chooseAndExecute("checkId", loginUser);

        // 指定名 checkName 策略：打印姓名
        abstractStrategyChoose.chooseAndExecute("checkName", loginUser);

        // 正则匹配策略: ^0752.*$
        abstractStrategyChoose.chooseAndExecute("0752-3323999", loginUser, true);

        // 指定名 error 策略：抛出异常
        abstractStrategyChoose.chooseAndExecute("error", loginUser);
    }

}
