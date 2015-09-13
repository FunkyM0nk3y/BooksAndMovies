package com.itesm.avril.cartelera;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Avril on 20/08/2015.
 */
public class MovieListAdapter extends BaseAdapter {

    Context context;
    List<Movie> rowItems;

    public MovieListAdapter(Context context, List<Movie> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater lay = (LayoutInflater) context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);
            convertView = lay.inflate(R.layout.list_view_movie, parent, false);
        }

        TextView cine = (TextView)convertView.findViewById(R.id.txtMovie);
        Movie r = rowItems.get(position);
        cine.setText(r.getCine());

        return convertView;
    }
}
