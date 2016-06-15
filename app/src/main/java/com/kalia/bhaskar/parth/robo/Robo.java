package com.kalia.bhaskar.parth.robo;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.kalia.bhaskar.parth.interfaces.InterpreterServiceInterface;
import com.kalia.bhaskar.parth.interfaces.ResponderServiceInterface;
import com.kalia.bhaskar.parth.interfaces.RoboInterface;
import com.kalia.bhaskar.parth.services.*;

import java.util.Locale;

/**
 * Created by bhaskar on 14/6/16.
 */

public class Robo implements RoboInterface {
    /*
    * is a robo (implements robo interface)
    * has a speaker
    * has a responder
    * has an interpreter
    * */

    private InterpreterServiceInterface interpreterService;
    private ResponderServiceInterface responderService;
    private TextToSpeech textToSpeech;


    /*
    * constructor
    * */

    public Robo(Context context){
        this.interpreterService = new InterpreterService();
        this.responderService = new ResponderService();
        this.textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
    }

    @Override
    public void respond(InterpretedAction ia, Context context) {
        if(ia != null){
            responderService.respond(ia,context,textToSpeech);
        }else{
            textToSpeech.speak("sorry you could not hear you", TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    public void interpret(String keyword, Context context) {
        respond(this.interpreterService.interpret(keyword,context),context);
    }
}