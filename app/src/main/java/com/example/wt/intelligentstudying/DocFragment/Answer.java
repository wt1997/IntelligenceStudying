package com.example.wt.intelligentstudying.DocFragment;

public class Answer {
    private String name;
    private String answer;
    private int ImageView;
    public Answer(int ImageView,String name,String answer){
        this.answer = answer;
        this.ImageView = ImageView;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageView() {
        return ImageView;
    }

    public String getAnswer() {
        return answer;
    }
}
