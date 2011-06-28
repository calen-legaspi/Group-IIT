package com.onb.bookreg.web.appcontext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextTest {

	@Test
	public void testApplicationContext() {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		appCon.equals(appCon);
	}
}
