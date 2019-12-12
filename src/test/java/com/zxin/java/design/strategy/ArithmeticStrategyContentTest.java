package com.zxin.java.design.strategy;

import com.zxin.java.design.strategy.inter.IArithmeticStrategy;
import com.zxin.java.design.strategy.inter.IStrategySelector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArithmeticStrategyContentTest {

    private IArithmeticStrategy strategy;

    @Autowired
    @Qualifier("defaultStrategySelector")
    private IStrategySelector selector;

    int a = 10;
    int b = 2;

    @Test
    public void test() {
        strategy = selector.select("multiply");
        System.out.println(strategy.execute(a , b));

    }
}