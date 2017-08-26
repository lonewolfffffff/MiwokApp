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

public class NumbersActivity extends AppCompatActivity {

    private WordClickListener mWordClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word( "One", "lutti", R.drawable.number_one, R.raw.number_one ));
        words.add(new Word( "Two", "otiiko", R.drawable.number_two, R.raw.number_two ));
        words.add(new Word( "Three", "tolookosu", R.drawable.number_three, R.raw.number_three ));
        words.add(new Word( "Four", "oyyisa", R.drawable.number_four, R.raw.number_four ));
        words.add(new Word( "Five", "massokka", R.drawable.number_five, R.raw.number_five ));
        words.add(new Word( "Six", "temmokka", R.drawable.number_six, R.raw.number_six ));
        words.add(new Word( "Seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven ));
        words.add(new Word( "Eight", "kawinta", R.drawable.number_eight, R.raw.number_eight ));
        words.add(new Word( "Nine", "wo’e", R.drawable.number_nine, R.raw.number_nine ));
        words.add(new Word( "Ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten ));

        WordAdapter adapter = new WordAdapter( this, words, R.color.category_numbers );
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
