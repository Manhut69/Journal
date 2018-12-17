package com.example.clintnieuwendijk.journal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    EntryDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Long id = getIntent().getLongExtra("id", 1);
        db = EntryDatabase.getInstance(getApplicationContext());

        TextView title = findViewById(R.id.titleDetailView);
        TextView content = findViewById(R.id.contentDetailView);
        TextView timestamp = findViewById(R.id.dateDetailView);
        ImageView mood = findViewById(R.id.moodDetailView);

        Cursor cursor = db.selectByID(id);
        title.setText(cursor.getString(cursor.getColumnIndex("title")));
        content.setText(cursor.getString(cursor.getColumnIndex("content")));
        timestamp.setText(cursor.getString(cursor.getColumnIndex("timestamp")));

        switch (cursor.getString(cursor.getColumnIndex("mood"))) {
            case "angry":
                mood.setImageResource(R.drawable.squidangry);
                break;
            case "confused":
                mood.setImageResource(R.drawable.squidconfused);
                break;
            case "glad":
                mood.setImageResource(R.drawable.squidglad);
                break;
            case "scared":
                mood.setImageResource(R.drawable.squidscared);
                break;
        }
    }
}
