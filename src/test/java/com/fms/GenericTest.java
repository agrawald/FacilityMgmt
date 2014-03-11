package com.fms;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by e7006722 on 6/03/14.
 */
public abstract class GenericTest extends TestCase {
    protected ApplicationContext appContext;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        appContext =
                new ClassPathXmlApplicationContext("src/webapp/WEB-INF/config/BeanLocation.xml");
    }
}
