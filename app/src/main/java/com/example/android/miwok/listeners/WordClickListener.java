package com.example.android.miwok.listeners;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;

import com.example.android.miwok.Word;

import java.util.ArrayList;

/**
 * Created by Haven on 21-08-2017.
 */

public class WordClickListener implements AdapterView.OnItemClickListener {

    private ArrayList<Word> mWords;
    private Context mContext;

    private MediaPlayer mMediaPlayer;

    public WordClickListener( Context context, ArrayList<Word> words ) {
        mWords = words;
        mContext = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Word wordClicked = mWords.get(position);

        mMediaPlayer = MediaPlayer.create( mContext, wordClicked.getAudioResourceId() );
        mMediaPlayer.start();
    }
}
