package github.helpers;

import github.SpringSelenideFrameworkApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = SpringSelenideFrameworkApplication.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

}
