package demo.paralleltests;

import base.helpers.BaseTest;
import base.pages.DataPage;
import com.codeborne.selenide.Selenide;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * This test class demonstrates how getBean method in BaseTest.getPage() works in parallel.
 * Run tests with mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suites/ParallelPageDataSuite.xml -Dspring.profiles.active=chrome
 * After test1 sets data as "test1" String for DataPage, test2 creates new instance of page without data added by previous test
 */
@Test
public class ParallelPagesTest extends BaseTest {

    public void test1(){
        DataPage page = getPage(DataPage.class);
        page.addSomeData("test1");
        Assertions.assertThat(page.getSomeData()).isEqualTo("test1");
    }

    public void test2(){
        //Wait for test1 inits page with test1-data
        Selenide.sleep(3000);
        DataPage page = getPage(DataPage.class);
        Assertions.assertThat(page.getSomeData()).isNull();
    }

    public void test3(){
        DataPage page = getPage(DataPage.class);
        page.addSomeData("test3");
        Assertions.assertThat(page.getSomeData()).isEqualTo("test3");
    }

    public void test4(){
        DataPage page = getPage(DataPage.class);
        page.addSomeData("test4");
        Assertions.assertThat(page.getSomeData()).isEqualTo("test4");
    }

}
