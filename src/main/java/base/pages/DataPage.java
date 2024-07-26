package base.pages;

import base.annotations.Page;

@Page
public class DataPage {

    private String data;

    public void addSomeData(String value){
        this.data = value;
    }

    public String getSomeData(){
        return data;
    }

}
