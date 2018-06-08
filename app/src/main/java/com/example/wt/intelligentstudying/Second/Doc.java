package com.example.wt.intelligentstudying.Second;

public class Doc {
    private String doc_name;
    private String doc_author;
    private String doc_time;
    public Doc(String doc_name,String doc_author,String doc_time){
        this.doc_author = doc_author;
        this.doc_name = doc_name;
        this.doc_time = doc_time;
    }
    public String getDoc_author() {
        return doc_author;
    }
    public String getDoc_name() {
        return doc_name;
    }
    public String getDoc_time() {
        return doc_time;
    }
}
