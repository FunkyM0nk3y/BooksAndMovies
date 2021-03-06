package com.itesm.avril.cartelera;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent main = new Intent(this, MainActivity.class);
                main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                return true;
            case R.id.action_books:
                Intent books = new Intent(this, Books.class);
                books.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(books);
                return true;
            case R.id.action_movies:
                Intent movies = new Intent(this, Movies.class);
                movies.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(movies);
                return true;
            case R.id.action_about:
                Intent about = new Intent(this, About.class);
                about.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
