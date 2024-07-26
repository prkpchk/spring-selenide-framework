package base.driver.configuration;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

/**
 * Spring Profile annotation used here to define which browser will be started for current test run
 * Profile can be set in properties spring.profiles.active=firefox
 * Or when using mvn test command mvn test -Dsurefire.suiteXmlFiles=[suite] -Dspring.profiles.active=firefox
 */
@Configuration
@Profile("firefox")
@SuppressWarnings("unused")
public class FirefoxConfig {

    @Bean
    public CustomScopeConfigurer newCustomScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        SimpleThreadScope threadScope = new SimpleThreadScope();
        configurer.addScope("thread", threadScope);
        return configurer;
    }

    @Bean
    @Scope(scopeName = "thread")
    public WebDriver getDriver() {
        WebDriver webDriver = new FirefoxDriver();
        WebDriverRunner.setWebDriver(webDriver);
        return webDriver;
    }

}