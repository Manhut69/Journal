package com.example.clintnieuwendijk.journal;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor c) {
        super(context, R.layout.entry_row, c, false);
    }

    public JournalEntry getItem(Cursor cursor) {
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String title = cursor.getString(cursor.getColumnIndex("title"));
        String content = cursor.getString(cursor.getColumnIndex("content"));
        String timestamp = cursor.getString(cursor.getColumnIndex("timestamp"));
        String mood = cursor.getString(cursor.getColumnIndex("mood"));

        return new JournalEntry(id, title, content, timestamp, mood);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){

        TextView title = view.findViewById(R.id.title);
        TextView content = view.findViewById(R.id.content);
        TextView timestamp = view.findViewById(R.id.timestamp);
        ImageView mood = view.findViewById(R.id.mood);

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
