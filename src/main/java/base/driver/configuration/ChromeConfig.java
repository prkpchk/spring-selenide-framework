package base.driver.configuration;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

/**
 * Spring Profile annotation used here to define which browser will be started for current test run
 * Profile can be set in properties spring.profiles.active=chrome
 * Or when using mvn test command mvn test -Dsurefire.suiteXmlFiles=[suite] -Dspring.profiles.active=chrome
 */
@Configuration
@Profile("chrome")
@SuppressWarnings("unused")
public class ChromeConfig {

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
        WebDriver webDriver = new ChromeDriver();
        WebDriverRunner.setWebDriver(webDriver);
        return webDriver;
    }
}
