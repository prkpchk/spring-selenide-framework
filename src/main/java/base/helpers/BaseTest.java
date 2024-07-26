package base.helpers;

import base.SpringSelenideFrameworkApplication;
import base.pages.Page;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = SpringSelenideFrameworkApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    public final <T> T getPage(Class<T> type) {
        if (!type.isAnnotationPresent(Page.class)) {
            throw new IllegalArgumentException("Class " + type.getName() + " is not annotated with @Page");
        }
        return this.applicationContext.getBean(type);
    }


}
