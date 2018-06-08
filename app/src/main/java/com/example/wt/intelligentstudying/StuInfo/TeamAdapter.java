package com.example.wt.intelligentstudying.StuInfo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wt.intelligentstudying.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder>{
    private List<Team> teamList;
    public static class TeamHolder extends RecyclerView.ViewHolder{
        TextView team_name;
        TextView teacher;
        TextView teamer;
        public TeamHolder(View view){
            super(view);
            team_name = view.findViewById(R.id.study_team_item_team_name);
            teacher = view.findViewById(R.id.study_team_item_team_teacher);
            teamer = view.findViewById(R.id.study_team_item_team_teamer);
        }
    }
    @Override
    public TeamHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.study_team_item,parent,false);
        return new TeamHolder(view);
    }
    @Override
    public void onBindViewHolder(TeamHolder teamHolder,int position){
        Team team = teamList.get(position);
        StringBuilder teamer = new StringBuilder();
        teamHolder.teacher.setText(team.getTeacher());
        teamHolder.team_name.setText(team.getTeam_name());
        for(int i=0;i<team.getTeamer().size();i++){
            if(i==(team.getTeamer().size()-1)){
                teamer.append(team.getTeamer().get(i));
            }else{
                teamer.append(team.getTeamer().get(i)+"、");
            }
        }
        teamHolder.teamer.setText(teamer);
    }
    @Override
    public int getItemCount(){
        return teamList.size();
    }
    public TeamAdapter(List<Team> teamList){
        this.teamList = teamList;
    }

}
