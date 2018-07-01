package com.besafx.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.besafx.android.R;
import com.besafx.android.entity.Department;

import java.util.List;

public class DepartmentGridAdapter extends BaseAdapter {

    private Context context;
    private List<Department> departments;

    public DepartmentGridAdapter(Context context, List<Department> departments) {
        this.context = context;
        this.departments = departments;
    }

    @Override
    public int getCount() {
        return departments.size();
    }

    @Override
    public Object getItem(int position) {
        return departments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return departments.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = layoutInflater.inflate(R.layout.fragment_department_item, parent, false);

        Department department = departments.get(position);

        TextView department_title = root.findViewById(R.id.department_title);
        TextView department_manager = root.findViewById(R.id.department_manager);

        department_title.setText(department.getName());
        department_manager.setText(department.getManager().getShortName());

        return root;
    }
}
