package com.bitbybit.demoaop;

import com.bitbybit.demoaop.test.TestBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class DemoAopApplicationTests {

	@Test
	public void contextLoads() {
		TestBean testBean = new TestBean();
		testBean.progressing();
	}

}
