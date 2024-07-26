package base.pages;

import com.codeborne.selenide.Selenide;

@Page
public class GitHubRepositoryPage{

    private String data;

    public GitHubRepositoryPage open(String login, String repoName){
        Selenide.open("https://github.com/" + login + "/" + repoName);
        return this;
    }

    public void addSomeData(String value){
        this.data = value;
    }

    public String getSomeData(){
        return data;
    }

}
