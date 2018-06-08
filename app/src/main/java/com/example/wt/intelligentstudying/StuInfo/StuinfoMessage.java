package com.example.wt.intelligentstudying.StuInfo;

public class StuinfoMessage {
    private int Image;
    private String sender;
    private String time;
    public StuinfoMessage(int image,String sender,String time){
        this.Image = image;
        this.sender = sender;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getSender() {
        return sender;
    }

    public int getImage() {
        return Image;
    }
}
