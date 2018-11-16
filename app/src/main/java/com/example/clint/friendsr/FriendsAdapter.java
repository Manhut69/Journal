package com.example.clint.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    ArrayList<Friend> friends;

    public FriendsAdapter(Context context, int resource, ArrayList<Friend> friends) {
        super(context, resource, friends);
        this.friends = friends;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.emojiImage);
        TextView txt = convertView.findViewById(R.id.emojiName);

        img.setImageResource(friends.get(position).getDrawableId());
        txt.setText(friends.get(position).getName());



        return convertView;
    }


}

