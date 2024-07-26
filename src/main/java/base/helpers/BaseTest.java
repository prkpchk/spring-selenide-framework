package base.helpers;

import base.SpringSelenideFrameworkApplication;
import base.annotations.Page;
import com.codeborne.selenide.WebDriverRunner;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

@SpringBootTest(classes = SpringSelenideFrameworkApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Override
    public void run(@NotNull IHookCallBack callBack, ITestResult testResult) {
        applicationContext.getBean(WebDriver.class);
        applicationContext.getBeansWithAnnotation(Page.class);
        super.run(callBack, testResult);
    }

    public final <T> T getPage(Class<T> type) {
        if (!type.isAnnotationPresent(Page.class)) {
            throw new IllegalArgumentException("Class " + type.getName() + " is not annotated with @Page. Annotate all Page Objects with @Page.");
        }
        return this.applicationContext.getBean(type);
    }

    @AfterMethod
    public void close(){
        if(WebDriverRunner.getWebDriver() != null)
            WebDriverRunner.getWebDriver().quit();
    }

}
