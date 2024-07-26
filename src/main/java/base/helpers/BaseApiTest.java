package base.helpers;

import base.SpringSelenideFrameworkApplication;
import com.codeborne.selenide.WebDriverRunner;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

@SpringBootTest(classes = SpringSelenideFrameworkApplication.class)
public class BaseApiTest extends AbstractTestNGSpringContextTests {

    @Override
    public void run(@NotNull IHookCallBack callBack, ITestResult testResult) {
        super.run(callBack, testResult);
    }

    @AfterMethod
    public void close(){
        if(WebDriverRunner.getWebDriver() != null)
            WebDriverRunner.getWebDriver().quit();
    }

}
