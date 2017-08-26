package com.example.android.miwok.activities;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.miwok.R;
import com.example.android.miwok.Word;
import com.example.android.miwok.adapters.WordAdapter;
import com.example.android.miwok.listeners.WordClickListener;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private WordClickListener mWordClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red ));
        words.add(new Word("Green", "chokokki", R.drawable.color_green, R.raw.color_green ));
        words.add(new Word("Brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown ));
        words.add(new Word("Gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray ));
        words.add(new Word("Black", "kululli", R.drawable.color_black, R.raw.color_black ));
        words.add(new Word("White", "kelelli", R.drawable.color_white, R.raw.color_white ));
        words.add(new Word("Dusty Yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow ));
        words.add(new Word("Mustard Yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow ));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors );
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        mWordClickListener = new WordClickListener(this, words, (AudioManager) getSystemService(Context.AUDIO_SERVICE));
        listView.setOnItemClickListener( mWordClickListener );
    }

    @Override
    protected void onStop() {
        super.onStop();

        mWordClickListener.releaseMediaPlayer();
    }
}
