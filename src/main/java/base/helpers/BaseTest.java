package base.helpers;

import base.SpringSelenideFrameworkApplication;
import com.codeborne.selenide.WebDriverRunner;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

@SpringBootTest(classes = SpringSelenideFrameworkApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    public void run(@NotNull IHookCallBack callBack, ITestResult testResult) {
        String msg = "[BeforeTestExecution] Commencing to run " + testResult.getMethod().getQualifiedName()
                + "() on thread " + Thread.currentThread().getId();
        System.err.println(msg);
        WebDriver driver = applicationContext.getBean(WebDriver.class);
        WebDriverRunner.setWebDriver(driver);
        super.run(callBack, testResult);
    }

    @AfterTest
    public void tearDown(){
        if(WebDriverRunner.getWebDriver() != null)
            WebDriverRunner.getWebDriver().quit();
    }

    public final <T> T getPage(Class<T> type) {
        return this.applicationContext.getBean(type);
    }


}
