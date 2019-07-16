package com.bitbybit.demoaop;

import com.bitbybit.demoaop.test.TestBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
//classes = {DemoAopApplication.class}
public class DemoAopApplicationTests {
    @Autowired
    TestBean testBean;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testAspect() {
        testBean.progressing();
    }
}
