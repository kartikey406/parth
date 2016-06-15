package com.kalia.bhaskar.parth.services;

import android.speech.tts.TextToSpeech;

import com.kalia.bhaskar.parth.interfaces.SpeakerServiceInterface;

/**
 * Created by bhaskar on 15/6/16.
 */
public class SpeakerService implements SpeakerServiceInterface {
    @Override
    public void speak(String text, TextToSpeech textToSpeech) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
