package junit;

import github.SpringSelenideFrameworkApplication;
import github.pages.GitHubRepositoryPage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = SpringSelenideFrameworkApplication.class)
public class JunitExampleTest {

/*    @Test
    @Order(1)
     void searchTest4(){
        GitHubRepositoryPage gitHubRepositoryPage = new GitHubRepositoryPage("prkpchk", "files");
        gitHubRepositoryPage.openSourceByName("");
    }

    @Test
    @Order(2)
    void searchTest1(){
        GitHubRepositoryPage gitHubRepositoryPage = new GitHubRepositoryPage("prkpchk", "files");
        gitHubRepositoryPage.openSourceByName("");
    }

    @Test
    void searchTest2(){
        GitHubRepositoryPage gitHubRepositoryPage = new GitHubRepositoryPage("prkpchk", "files");
        gitHubRepositoryPage.openSourceByName("");
    }*/

}
