package ui;

import base.helpers.BaseTest;
import base.pages.DataPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * This test class demonstrates how getBean method in BaseTest.getPage() works in parallel.
 * Run tests with mvn test -Dsurefire.suiteXmlFiles=src/test/resources/suites/ParallelPageDataSuite.xml -Dspring.profiles.active=chrome
 * After test1 sets data as "test1" String for DataPage, test2 creates new instance of page without data added by previous test
 */
public class ParallelPagesTest extends BaseTest {

    @Test
    public void test1(){
        DataPage page = getPage(DataPage.class);
        page.addSomeData("test1");
        Assertions.assertThat(page.getSomeData()).isEqualTo("test1");
    }

    @Test
    public void test2(){
        DataPage page = getPage(DataPage.class);
        Assertions.assertThat(page.getSomeData()).isNull();
    }

}
