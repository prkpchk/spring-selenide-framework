package github.pages;

import com.codeborne.selenide.Selenide;
import org.springframework.stereotype.Component;

@Component
public class GitHubRepositoryPage {

    public GitHubRepositoryPage open(String login, String repoName){
        Selenide.open("https://github.com/" + login + "/" + repoName);
        return this;
    }

    public void clickFileByName(String name){
    }

}
