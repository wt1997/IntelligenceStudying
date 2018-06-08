package com.example.wt.intelligentstudying.Second;

public class ExcellentPage {
    private String author;
    private String page_text;
    private int page_image;
    public ExcellentPage(String author,String page_text,int page_image){
        this.author = author;
        this.page_image = page_image;
        this.page_text = page_text;
    }
    public int getPage_image(){
        return page_image;
    }
    public String getAuthor(){
        return author;
    }
    public String getPage_text(){
        return page_text;
    }
}
