package com.example.wt.intelligentstudying.StuInfo;

import java.util.List;

public class Team {
    private String team_name;
    private List<String> teamer;
    private String teacher;
    public Team(String team_name,List<String> teamer,String teacher){
        this.team_name = team_name;
        this.teamer = teamer;
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTeam_name() {
        return team_name;
    }

    public List<String> getTeamer() {
        return teamer;
    }
}
