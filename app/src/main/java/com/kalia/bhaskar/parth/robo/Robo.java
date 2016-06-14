package com.kalia.bhaskar.parth.robo;

import android.content.Context;
import android.speech.tts.TextToSpeech;

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

    private InterpreterService interpreterService;
    private ResponderService responderService;
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
        responderService.respond(ia,context,textToSpeech);
    }

    @Override
    public void interpret(String keyword, Context context) {
        respond(this.interpreterService.interpret(keyword,context),context);
    }
}
