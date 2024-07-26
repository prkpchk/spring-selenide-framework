package base.driver;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("firefox")
public class FirefoxDriverImpl implements Driver {

    private WebDriver webDriver;

    public FirefoxDriverImpl() {
        this.webDriver = new FirefoxDriver();
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
