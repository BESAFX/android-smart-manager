package com.besafx.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.besafx.android.R;
import com.besafx.android.entity.Team;

import java.util.List;

public class TeamGridAdapter extends BaseAdapter {

    private Context context;
    private List<Team> teams;

    public TeamGridAdapter(Context context, List<Team> teams) {
        this.context = context;
        this.teams = teams;
    }

    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return teams.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = layoutInflater.inflate(R.layout.fragment_team_item, parent, false);

        Team team = teams.get(position);

        TextView team_title = root.findViewById(R.id.team_title);
        TextView team_persons_count = root.findViewById(R.id.team_persons_count);

        team_title.setText(team.getName());
        team_persons_count.setText(context.getResources().getText(R.string.persons_count).toString() + team.getPersons().size());

        return root;
    }
}
