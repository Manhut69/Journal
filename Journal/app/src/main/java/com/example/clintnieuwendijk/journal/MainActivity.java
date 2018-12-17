package com.example.clintnieuwendijk.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EntryDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = EntryDatabase.getInstance(getApplicationContext());

        if (getIntent().getStringExtra("title") != null) {
            String title = getIntent().getStringExtra("title");
            String content = getIntent().getStringExtra("content");
            String mood = getIntent().getStringExtra("mood");
            JournalEntry je = new JournalEntry(0, title, content, mood, null);
            db.insert(je);
            Log.d(title, content);
        }

        updateData();

    }

    private void updateData() {
        Cursor allEntries = db.selectAll();
        ListView lv = findViewById(R.id.mainListView);
        EntryAdapter entryAdapter = new EntryAdapter(getApplicationContext(), allEntries);

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
            Log.d(Long.toString(l), Integer.toString(i));
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("id", l);
            startActivity(intent);
        }
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            db.delete(l);
            updateData();
            return true;
        }
    }
}
