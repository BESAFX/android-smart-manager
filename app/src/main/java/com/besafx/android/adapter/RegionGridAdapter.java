package com.besafx.android.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.besafx.android.R;
import com.besafx.android.entity.Region;

import java.util.List;

public class RegionGridAdapter extends BaseAdapter {

    private Context context;
    private List<Region> regions;
    private SparseBooleanArray mSelectedItemsIds;

    public RegionGridAdapter(Context context, List<Region> regions) {
        this.context = context;
        this.regions = regions;
    }

    @Override
    public int getCount() {
        return regions.size();
    }

    @Override
    public Object getItem(int position) {
        return regions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return regions.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = layoutInflater.inflate(R.layout.fragment_region_item, parent, false);

        Region region = regions.get(position);

        TextView region_title = root.findViewById(R.id.region_title);
        TextView region_manager = root.findViewById(R.id.region_manager);

        region_title.setText(region.getName());
        region_manager.setText(region.getManager().getName());

        return root;
    }
}
