package com.besafx.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.besafx.android.R;
import com.besafx.android.entity.Person;

import java.util.List;

public class PersonGridAdapter extends BaseAdapter {

    private Context context;
    private List<Person> persons;

    public PersonGridAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return persons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = layoutInflater.inflate(R.layout.fragment_person_item, parent, false);

        Person person = persons.get(position);

        TextView person_name = root.findViewById(R.id.person_name);
        TextView person_qualification = root.findViewById(R.id.person_qualification);

        person_name.setText(person.getShortName());
        person_qualification.setText(person.getQualification());

        return root;
    }
}
