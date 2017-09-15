package com.example.vindhya.proxynotes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vindhya.proxynotes.Model.ListItemModel;
import com.example.vindhya.proxynotes.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {


    Context context;
    ArrayList<ListItemModel> itemDtat;

    public CustomAdapter(Context context, ArrayList<ListItemModel> itemDtat) {
        super(context, R.layout.z_custom_item_view, itemDtat);
        this.context = context;
        this.itemDtat = itemDtat;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(context);
            convertView = layoutInflator.inflate(R.layout.z_custom_item_view, null);
            holder = new ViewHolder();
            holder.thumb = (ImageView) convertView.findViewById(R.id.thumbId);
            holder.title = (TextView) convertView.findViewById(R.id.videoTitleId);
            holder.description = (TextView) convertView.findViewById(R.id.descriptionId);
            holder.url = (TextView) convertView.findViewById(R.id.urlId);
            holder.duration = (TextView) convertView.findViewById(R.id.durationId);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ListItemModel listItemModel = itemDtat.get(position);

        holder.thumb.setImageResource(listItemModel.getThumb());
        holder.title.setText(listItemModel.getTitle());
        holder.description.setText(listItemModel.getDiscription());
        holder.url.setText(listItemModel.getUrl());
        holder.duration.setText(listItemModel.getDuration());

        return convertView;
    }

    public class ViewHolder {
        ImageView thumb;
        TextView title, description, url, duration;
    }
}