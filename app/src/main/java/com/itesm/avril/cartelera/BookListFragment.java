package com.itesm.avril.cartelera;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by FunkyM0nk3y on 9/12/15.
 */
public class BookListFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        BookLoadAsyncTask ct = new BookLoadAsyncTask(getActivity(), this);
        ct.execute("https://www.googleapis.com/fusiontables/v1/query?sql=SELECT*FROM%201yaQf8jN3uRcxzRf5j_F0s_zDlEXJbHUNutRUP_C5&key=AIzaSyAlsPp8O3KO182A7gptA6Foy8U5MgDi064");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub

        super.onListItemClick(l, v, position, id);
        Book r = (Book) getListAdapter().getItem(position);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity(), 0);
        alertDialog.setTitle("Books");
        alertDialog.setMessage("Title: " + r.getTitle() + "\n" +
                        "Authors: " + r.getAuthors() + "\n" +
                        "Publisher: " + r.getPublisher() + "\n" +
                        "ISBN: " + r.getIsbn() + "\n" +
                        "Pages: " + r.getPages() + "\n" +
                        "Price: " + r.getPrice()
        );
        //Setting Button "Continuar"
        alertDialog.setPositiveButton("Continue",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}
