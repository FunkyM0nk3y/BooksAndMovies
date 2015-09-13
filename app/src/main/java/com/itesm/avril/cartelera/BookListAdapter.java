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
 * Created by FunkyM0nk3y on 9/12/15.
 */
public class BookListAdapter extends BaseAdapter {
    Context context;
    List<Book> rowItems;

    public BookListAdapter(Context context, List<Book> rowItems) {
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
        if (convertView == null) {
            LayoutInflater lay = (LayoutInflater) context.getSystemService(
                    Activity.LAYOUT_INFLATER_SERVICE);
            convertView = lay.inflate(R.layout.list_view_book, parent, false);
        }

        TextView book = (TextView) convertView.findViewById(R.id.txtBook);
        Book r = rowItems.get(position);
        book.setText(r.getTitle());

        return convertView;
    }
}
