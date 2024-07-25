package github;

import github.helpers.BaseTest;
import github.pages.GitHubRepositoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class SearchTestngTest extends BaseTest {

    @Autowired
    private GitHubRepositoryPage gitHubRepositoryPage;

    @Test(priority = 1)
    public void searchTest4(){
        gitHubRepositoryPage.open("prkpchk", "files");
        gitHubRepositoryPage.clickFileByName("");
    }

}
