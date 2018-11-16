package com.example.clint.friendsr;

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
            Log.d("Omg", "Clicked");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Alien", "Bacteria", "Bicep", "B symbol", "Borgar", "The next Ye cd", "Cheeky face", "Chemist", "Clock", "Copyright", "Curling stone", "Stack of dollar bills", "Save button", "Full moon with face", "Purple heart <3", "Red heart <3", "'Metal hands'", "Takeshis Castle", "Japanese donut", "July 17th", "Moon rune", "Moai", "New moon with face", "Ok sign", "Penguin", "Poop emoji", "Pride flag", "Sax", "Snatch (female)", "Supergirl", "Trumpet", "D&D Player"));
        ArrayList<String> bios = new ArrayList<>(Arrays.asList("Ayy lmao", "The top left one is heptatitis!", "Stronk!", "[B]OIIII", "Bun // The above ingredient twice // The next ingredient twice // Bun", "Giff Yahndi", "If you know what I mean", "Don't drink that!", "The most useless of the most useless emoji", "Funnily enough this picture is open source", "Heavier than you think", "'nothing much just chillin, trying to stack these millions'", "A:/", "Best friends with new moon with face", "A distinguished award", "Love is in the air", "Probably yells 'Slayer' at concerts", "Guy LeDouche live reporting", "A rice ball!", "The best day ever", "Japanese for 'Open for business'", "Try to make a picture without touching his nose", "Best friends with full moon with face", "Lit!", "The best animal", "Never number 1", "World wide!", "And violence", "Geddit? :D", "Here to save the day", "Doot doot", "I'm a lvl 3 fighter, 8 wizard, 9 sorcerer, 1 barbarian and 2 bard, that was the most optimal build for my stats."));
        ArrayList<Integer> ids = new ArrayList<>(Arrays.asList(getResources().getIdentifier("alien.png", "drawable", getPackageName()), getResources().getIdentifier("bacteria.png", "drawable", getPackageName()), getResources().getIdentifier("bicep.png", "drawable", getPackageName()), getResources().getIdentifier("bsymbol.png", "drawable", getPackageName()), getResources().getIdentifier("burger.png", "drawable", getPackageName()), getResources().getIdentifier("cdcase.png", "drawable", getPackageName()), getResources().getIdentifier("cheeky.png", "drawable", getPackageName()), getResources().getIdentifier("chemist.png", "drawable", getPackageName()), getResources().getIdentifier("clock.png", "drawable", getPackageName()), getResources().getIdentifier("copyright.png", "drawable", getPackageName()), getResources().getIdentifier("curlstone.png", "drawable", getPackageName()), getResources().getIdentifier("dollarbills.png", "drawable", getPackageName()), getResources().getIdentifier("floppydisk.png", "drawable", getPackageName()), getResources().getIdentifier("fullmoonface.png", "drawable", getPackageName()), getResources().getIdentifier("heartpurple.png", "drawable", getPackageName()), getResources().getIdentifier("heartred.png", "drawable", getPackageName()), getResources().getIdentifier("hornhand.png", "drawable", getPackageName()), getResources().getIdentifier("japancastle.png", "drawable", getPackageName()), getResources().getIdentifier("japanesedonut.png", "drawable", getPackageName()), getResources().getIdentifier("july17.png", "drawable", getPackageName()), getResources().getIdentifier("kanji.png", "drawable", getPackageName()), getResources().getIdentifier("moai.png", "drawable", getPackageName()), getResources().getIdentifier("newmoonface.png", "drawable", getPackageName()), getResources().getIdentifier("oksign.png", "drawable", getPackageName()), getResources().getIdentifier("penguin.png", "drawable", getPackageName()), getResources().getIdentifier("poop.png", "drawable", getPackageName()), getResources().getIdentifier("rainbowflag.png", "drawable", getPackageName()), getResources().getIdentifier("sax.png", "drawable", getPackageName()), getResources().getIdentifier("snatchfemale.png", "drawable", getPackageName()), getResources().getIdentifier("supergirl.png", "drawable", getPackageName()), getResources().getIdentifier("trumpet.png", "drawable", getPackageName()), getResources().getIdentifier("wizardmale.png", "drawable", getPackageName())));
        for (int i = 0; i < names.size(); i++) {
            friends.add(new Friend(names.get(i), bios.get(i), ids.get(i)));
        }
        Log.d("List length:", Integer.toString(friends.size()));

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView view = findViewById(R.id.MainGrid);
        view.setAdapter(adapter);

        view.setOnItemClickListener(new GridItemClickListener());
    }

}
