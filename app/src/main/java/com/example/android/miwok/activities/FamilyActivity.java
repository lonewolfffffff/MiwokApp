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

public class FamilyActivity extends AppCompatActivity {

    private WordClickListener mWordClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father", "әpә", R.drawable.family_father, R.raw.family_father ));
        words.add(new Word("Mother", "әṭa", R.drawable.family_mother, R.raw.family_mother ));
        words.add(new Word("Son", "angsi", R.drawable.family_son, R.raw.family_son ));
        words.add(new Word("Daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter ));
        words.add(new Word("Older Brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother ));
        words.add(new Word("Younger Brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother ));
        words.add(new Word("Older Sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister ));
        words.add(new Word("Younger Sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister ));
        words.add(new Word("Grandmother ", "ama", R.drawable.family_grandmother, R.raw.family_grandmother ));
        words.add(new Word("Grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather ));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family );
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
