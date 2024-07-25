package ui;

import base.helpers.BaseTest;
import base.pages.GitHubRepositoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

@Test
public class SampleTest extends BaseTest {

    @Autowired
    private GitHubRepositoryPage gitHubRepositoryPage;

    public void searchTest4(){
        gitHubRepositoryPage.open("prkpchk", "files");
        gitHubRepositoryPage.clickFileByName("");
    }

}
