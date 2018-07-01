package com.besafx.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.besafx.android.R;
import com.besafx.android.entity.Branch;

import java.util.List;

public class BranchGridAdapter extends BaseAdapter {

    private Context context;
    private List<Branch> branches;

    public BranchGridAdapter(Context context, List<Branch> branches) {
        this.context = context;
        this.branches = branches;
    }

    @Override
    public int getCount() {
        return branches.size();
    }

    @Override
    public Object getItem(int position) {
        return branches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return branches.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = layoutInflater.inflate(R.layout.fragment_branch_item, parent, false);

        Branch branch = branches.get(position);

        TextView branch_title = root.findViewById(R.id.branch_title);
        TextView branch_manager = root.findViewById(R.id.branch_manager);

        branch_title.setText(branch.getName());
        branch_manager.setText(branch.getManager().getShortName());

        return root;
    }
}
