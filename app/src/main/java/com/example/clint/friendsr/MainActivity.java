package com.example.clint.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Log.d("Omg", clickedFriend.getName());

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Alien", "Bacteria", "Bicep", "B symbol", "Borgar", "The next Ye cd", "Cheeky face", "Chemist", "Clock", "Copyright", "Curling stone", "Stack of dollar bills", "Save button", "Full moon with face", "Purple heart <3", "Red heart <3", "'Metal hands'", "Takeshis Castle", "Japanese donut", "July 17th", "Moon rune", "Moai", "New moon with face", "Ok sign", "Penguin", "Poop emoji", "Pride flag", "Sax", "Snatch (female)", "Supergirl", "Trumpet", "D&D Player"));
        ArrayList<String> bios = new ArrayList<>(Arrays.asList("Ayy lmao", "The top left one is heptatitis!", "Stronk!", "[B]OIIII", "Bun // The above ingredient twice // The next ingredient twice // Bun", "Giff Yahndi", "If you know what I mean", "Don't drink that!", "The most useless of the most useless emoji", "Funnily enough this picture is open source", "Heavier than you think", "'nothing much just chillin, trying to stack these millions'", "A:/", "Best friends with new moon with face", "A distinguished award", "Love is in the air", "Probably yells 'Slayer' at concerts", "Guy LeDouche live reporting", "A rice ball!", "The best day ever", "Japanese for 'Open for business'", "Try to make a picture without touching his nose", "Best friends with full moon with face", "Lit!", "The best animal", "Never number 1", "World wide!", "And violence", "Geddit? :D", "Here to save the day", "Doot doot", "I'm a lvl 3 fighter, 8 wizard, 9 sorcerer, 1 barbarian and 2 bard, that was the most optimal build for my stats."));
        ArrayList<Integer> ids = new ArrayList<>(Arrays.asList(getResources().getIdentifier("alien", "drawable", this.getPackageName()), getResources().getIdentifier("bacteria", "drawable", this.getPackageName()), getResources().getIdentifier("bicep", "drawable", this.getPackageName()), getResources().getIdentifier("bsymbol", "drawable", this.getPackageName()), getResources().getIdentifier("burger", "drawable", this.getPackageName()), getResources().getIdentifier("cdcase", "drawable", this.getPackageName()), getResources().getIdentifier("cheeky", "drawable", this.getPackageName()), getResources().getIdentifier("chemist", "drawable", this.getPackageName()), getResources().getIdentifier("clock", "drawable", this.getPackageName()), getResources().getIdentifier("copyright", "drawable", this.getPackageName()), getResources().getIdentifier("curlstone", "drawable", this.getPackageName()), getResources().getIdentifier("dollarbills", "drawable", this.getPackageName()), getResources().getIdentifier("floppydisk", "drawable", this.getPackageName()), getResources().getIdentifier("fullmoonface", "drawable", this.getPackageName()), getResources().getIdentifier("heartpurple", "drawable", this.getPackageName()), getResources().getIdentifier("heartred", "drawable", this.getPackageName()), getResources().getIdentifier("hornhand", "drawable", this.getPackageName()), getResources().getIdentifier("japancastle", "drawable", this.getPackageName()), getResources().getIdentifier("japanesedonut", "drawable", this.getPackageName()), getResources().getIdentifier("july17", "drawable", this.getPackageName()), getResources().getIdentifier("kanji", "drawable", this.getPackageName()), getResources().getIdentifier("moai", "drawable", this.getPackageName()), getResources().getIdentifier("newmoonface", "drawable", this.getPackageName()), getResources().getIdentifier("oksign", "drawable", this.getPackageName()), getResources().getIdentifier("penguin", "drawable", this.getPackageName()), getResources().getIdentifier("poop", "drawable", this.getPackageName()), getResources().getIdentifier("rainbowflag", "drawable", this.getPackageName()), getResources().getIdentifier("sax", "drawable", this.getPackageName()), getResources().getIdentifier("snatchfemale", "drawable", this.getPackageName()), getResources().getIdentifier("supergirl", "drawable", this.getPackageName()), getResources().getIdentifier("trumpet", "drawable", this.getPackageName()), getResources().getIdentifier("wizardmale", "drawable", this.getPackageName())));
        for (int i = 0; i < names.size(); i++) {
            friends.add(new Friend(names.get(i), bios.get(i), ids.get(i)));
            Log.d(names.get(i), Integer.toString(ids.get(i)));
        }

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView view = findViewById(R.id.MainGrid);
        view.setAdapter(adapter);

        view.setOnItemClickListener(new GridItemClickListener());
    }

}
