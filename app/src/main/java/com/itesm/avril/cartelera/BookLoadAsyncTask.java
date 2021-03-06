package com.itesm.avril.cartelera;

import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by FunkyM0nk3y on 9/12/15.
 */
public class BookLoadAsyncTask extends AsyncTask<String, String, ArrayList<Book>> {

    private Context contexto;
    private ListFragment lista;
    private ProgressDialog dialog;

    public BookLoadAsyncTask(Context c, ListFragment f) {
        contexto = c;
        lista = f;
        dialog = new ProgressDialog(contexto);
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        dialog.setTitle("Loading...");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }

    private String gimmeJSON(String jsonURL) {
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(jsonURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.connect();

            int status = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception ex) {
            Log.e("Error", "File not found. e: " + ex);
        } finally {
            connection.disconnect();
        }
        return builder.toString();
    }

    @Override
    protected ArrayList<Book> doInBackground(String... params) {
        ArrayList<Book> objects = new ArrayList<Book>();
        String json = gimmeJSON(params[0]);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray array = object.getJSONArray("rows");
            for (int i = 0; i < array.length(); i++) {
                JSONArray ob = array.getJSONArray(i);
                String title = ob.getString(0);
                String authors = ob.getString(1);
                String publisher = ob.getString(2);
                String isbn = ob.getString(3);
                String pages = ob.getString(4);
                String price = ob.getString(5);
                objects.add(new Book(title, authors, publisher, isbn, pages, price));
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return objects;
    }

    @Override
    protected void onPostExecute(ArrayList<Book> result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        BookListAdapter adp = new BookListAdapter(contexto, result);
        lista.setListAdapter(null);
        lista.setListAdapter(adp);

        dialog.dismiss();
    }
}
