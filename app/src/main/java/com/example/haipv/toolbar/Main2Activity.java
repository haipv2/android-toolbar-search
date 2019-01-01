package com.example.haipv.toolbar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView listView;
    ArrayList list;
    ArrayAdapter adapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.listView);
        list = new ArrayList();
        list.add("ABCD");
        list.add("eee");
        list.add("advc");
        list.add("aaaaa");
        list.add("bbbb");
        list.add("ccc");
        list.add("eeeeccc");
        list.add("yyyy");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
//        adapter = new ArrayAdapter<String>(Main2Activity.this,
//                android.R.layout.simple_list_item_1,
//                getResources().getStringArray(R.array.months_array));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Main2Activity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        textView = findViewById(R.id.emptyView);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        listView.setEmptyView(textView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) searchViewItem.getActionView();
        searchView.setQueryHint("Search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                searchView.clearFocus();
                /*if (list.contains(query)) {
                    adapter.getFilter().filter(query);
                }else {
                    Toast.makeText(Main2Activity.this, "no match found", Toast.LENGTH_LONG).show();
                }*/
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
