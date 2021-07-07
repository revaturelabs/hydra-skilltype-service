package com.revature.hydra.skilltype;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.hydra.test.util.TestContext;
import com.revature.hydra.test.util.WebAppContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class, WebAppContext.class })
@SpringBootTest
public class HydraSkillTypeServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
