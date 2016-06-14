package com.kalia.bhaskar.parth.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;

import com.kalia.bhaskar.parth.robo.InterpretedAction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhaskar on 14/6/16.
 */

/*
* this service will help robo to respond
* to whatever user says (it must be a keyword though)
*
* based on keyword it can either speak or perform some other action (such as calling someone etc)
* */

public class ResponderService {
    private Map<String, String> keywordToTextMap;
    //TextToSpeech t;

    public ResponderService(){
        generateMap();
    }

    public void respond(InterpretedAction ia,Context context,TextToSpeech textToSpeech){
        try{
            if(ia.getType().equals("speak")){
                speak(keywordToTextMap.get(ia.getKeyword()),textToSpeech);
            }else{
                work(ia.getKeyword(),context);
            }
        }catch (Exception e){
            e.printStackTrace();
            speak("sorry i am not programmed for this command. please ask my owner to program it in to me",textToSpeech);
        }
    }

    private void speak(String text, TextToSpeech textToSpeech){
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    private void work(String keyword, Context context){ //call for other actions like launching another activity
        /*
        * parse the keyword for getting 'service' and 'input'
        * eg. 'call bhaskar'
        *       in above keyword (service is calling, input is contact ie. bhaskar)
        * */

        switch(keyword){
            case "sleep":
                //((Activity)context).finish();
                //System.exit(0);
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void generateMap(){


        /*
        * in future generate this map from file
        * map : {keyword:text to speak}
        * */

        keywordToTextMap = new HashMap<String, String>();
        keywordToTextMap.put("hello","hello beautiful");
        keywordToTextMap.put("what is your name","my name is robo Arjun");
        keywordToTextMap.put("who is your owner","my owner is  bhaskar kalia");
    }

}
