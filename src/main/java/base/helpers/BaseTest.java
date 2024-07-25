package base.helpers;

import base.SpringSelenideFrameworkApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = SpringSelenideFrameworkApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

}
