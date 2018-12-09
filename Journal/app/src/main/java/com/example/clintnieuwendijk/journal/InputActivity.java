package com.example.clintnieuwendijk.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void makeEntry(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.squidAngry:
                je.setMood("angry");
                break;
            case R.id.squidConfused:
                je.setMood("confused");
                break;
            case R.id.squidGlad:
                je.setMood("glad");
                break;
            case R.id.squidScared:
                je.setMood("scared");
                break;
        }

        EditText content =  findViewById(R.id.storyText);
        EditText title = findViewById(R.id.titleText);
        je.setContent(content.getText().toString());
        je.setTitle(title.getText().toString());
        EntryDatabase eb = new EntryDatabase();
        eb.insert(je);
    }
}
