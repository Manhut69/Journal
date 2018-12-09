package com.example.clintnieuwendijk.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        Cursor allEntries = db.selectAll();
        EntryAdapter entryAdapter = new EntryAdapter(this, allEntries);
        ListView lv = findViewById(R.id.mainListView);
        lv.setAdapter(entryAdapter);
        lv.setOnItemClickListener(new OnItemClickListener());
        lv.setOnItemLongClickListener(new OnItemLongClickListener());
    }

    public void createNewEntryClick(View v) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }


    public void confirmButtonClick(View v) {
        Log.d("Confirm", "Clicked");
    }

    private class OnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("Itemclick", "Item clicked");
        }
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("Longclick", "Item clicked");
            return true;
        }
    }


}
