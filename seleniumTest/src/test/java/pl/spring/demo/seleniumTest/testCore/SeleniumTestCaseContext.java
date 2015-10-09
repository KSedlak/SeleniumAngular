package pl.spring.demo.seleniumTest.testCore;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("pl.spring.demo.seleniumTest")
@PropertySource("pl/spring/demo/seleniumTest/spring/app.properties")
public class SeleniumTestCaseContext {
 
 @Bean
 public TestScope testScope() {
  return new TestScope();
 }
 
 @Bean
 public CustomScopeConfigurer customScopeConfigurer() {
  CustomScopeConfigurer scopeConfigurer = new CustomScopeConfigurer();
  Map<String, Object> scopes = new HashMap<>();
  scopes.put("test", testScope());
  scopeConfigurer.setScopes(scopes);
  return scopeConfigurer;
 }
 
 @Bean
 public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
     return new PropertySourcesPlaceholderConfigurer();
 }
 
 @Bean
 @Scope("test")
 public WebDriver webDriver() {
  return new FirefoxDriver();
 }
}