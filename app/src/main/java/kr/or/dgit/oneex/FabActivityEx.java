package kr.or.dgit.oneex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
public class FabActivityEx extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_ex);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myListView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        myListView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addListItem();
                Snackbar.make(view, "item added to list", Snackbar.LENGTH_LONG)
                        .setAction("Action", undoOnClickListener).show();
            }
        });
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listItems.remove(listItems.size()-1);
                adapter.notifyDataSetChanged();
               /* Snackbar.make(v, "Item removed", Snackbar.LENGTH_LONG).setAction("Action", null).show();*/
            }
        });
    }

    private void addListItem(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREA);
        listItems.add(sdf.format(new Date()));
        adapter.notifyDataSetChanged();
    }

    View.OnClickListener undoOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            listItems.remove(listItems.size()-1);
            adapter.notifyDataSetChanged();
            Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    };

}
