package com.example.wt.intelligentstudying.Second;

public class Quenstion {
    private String author;
    private String time;
    private String title;
    private String contents;
    private int num_agree;
    private int num_diss;
    private int author_image;
    public Quenstion(String author,String time,String title,String contents,int num_agree,
                     int num_diss,int author_image){
        this.author = author;
        this.time = time;
        this.title = title;
        this.contents = contents;
        this.num_agree = num_agree;
        this.num_diss = num_diss;
        this.author_image = author_image;
    }

    public String getAuthor() {
        return author;
    }

    public int getNum_agree() {
        return num_agree;
    }

    public int getNum_diss() {
        return num_diss;
    }

    public String getContents() {
        return contents;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthor_image() {
        return author_image;
    }
}
