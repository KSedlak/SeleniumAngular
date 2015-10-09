package pl.spring.demo.seleniumTest.testCore;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SeleniumTestCaseContext.class)
@TestExecutionListeners({ SeleniumTestExecutionListener.class,
 DependencyInjectionTestExecutionListener.class })
public abstract class SeleniumTestCase {}