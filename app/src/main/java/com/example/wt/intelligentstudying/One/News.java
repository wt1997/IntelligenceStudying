package com.example.wt.intelligentstudying.One;

public class News {
    private String newsInfo;
    private int imageId;
    public News(String newsInfo,int imageId){
        this.newsInfo = newsInfo;
        this.imageId = imageId;
    }
    public int getImageId(){
        return imageId;
    }
    public String getNewsInfo(){
        return newsInfo;
    }
}
