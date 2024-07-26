package base.driver;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("chrome")
public class ChromeDriverImpl implements Driver {

    private WebDriver webDriver;

    public ChromeDriverImpl() {
        this.webDriver = new ChromeDriver();
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
