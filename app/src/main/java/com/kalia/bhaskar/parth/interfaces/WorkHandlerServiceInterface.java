package com.kalia.bhaskar.parth.interfaces;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.kalia.bhaskar.parth.robo.InterpretedAction;

/**
 * Created by bhaskar on 15/6/16.
 */
public interface WorkHandlerServiceInterface {
    public void work(InterpretedAction ia, Context context, TextToSpeech textToSpeech);
}
