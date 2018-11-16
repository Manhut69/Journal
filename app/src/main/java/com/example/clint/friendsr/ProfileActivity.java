package com.example.clint.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;


    private class ChangeRating implements RatingBar.OnRatingBarChangeListener {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), rating);
            ratingBar.setRating(rating);
            editor.apply();
            Log.d("Changed rating to:", Float.toString(rating));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat(retrievedFriend.getName(), 0);
        Log.d(retrievedFriend.getName(), Float.toString(rating));

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        if(rating > 0) {
            ratingBar.setRating(rating);
        }
        else {
            ratingBar.setRating(0);
        }
        ratingBar.setOnRatingBarChangeListener(new ChangeRating());


        ImageView img = findViewById(R.id.profileImage);
        TextView nameTxt = findViewById(R.id.profileName);
        TextView bioTxt = findViewById(R.id.profileBio);

        img.setImageResource(retrievedFriend.getDrawableId());
        nameTxt.setText(retrievedFriend.getName());
        bioTxt.setText(retrievedFriend.getBio());
    }

}
