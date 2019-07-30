package com.example.clintnieuwendijk.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    // intialize input screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    // create intent to make the main activity update the database
    public void makeEntry(View v) {
        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        switch (v.getId()) {
            case R.id.squidAngry:
                intent.putExtra("mood", "angry");
                break;
            case R.id.squidConfused:
                intent.putExtra("mood", "confused");
                break;
            case R.id.squidGlad:
                intent.putExtra("mood", "glad");
                break;
            case R.id.squidScared:
                intent.putExtra("mood", "scared");
                break;
        }

        EditText content =  findViewById(R.id.storyText);
        intent.putExtra("content", content.getText().toString());
        EditText title = findViewById(R.id.titleText);
        intent.putExtra("title", title.getText().toString());

        startActivity(intent);
    }
}
