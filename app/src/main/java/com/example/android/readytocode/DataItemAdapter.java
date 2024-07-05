package com.example.android.readytocode;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.readytocode.models.DataItem;

import java.util.List;

public class DataItemAdapter extends ArrayAdapter<DataItem> {

    List<DataItem> mDataitems;
    LayoutInflater mInflater;
    public DataItemAdapter(@NonNull Context context,  @NonNull List<DataItem> objects) {
        super(context, R.layout.list_item, objects);
        mDataitems = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent , false);
        }

        TextView tvName = convertView.findViewById(R.id.itemNameText);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        DataItem item = mDataitems.get(position);
        tvName.setText(item.getItemName());
        imageView.setImageResource(R.drawable.bishop);

        return convertView;
    }
}
