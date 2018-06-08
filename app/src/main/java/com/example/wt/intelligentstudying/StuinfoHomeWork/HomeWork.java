package com.example.wt.intelligentstudying.StuinfoHomeWork;

public class HomeWork {
    private String teacher;
    private String course;
    private String title;
    private String deadline;
    public HomeWork(String teacher, String course, String title, String deadline){
        this.course = course;
        this.deadline = deadline;
        this.teacher = teacher;
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTitle() {
        return title;
    }

    public String getCourse() {
        return course;
    }

    public String getDeadline() {
        return deadline;
    }
}
