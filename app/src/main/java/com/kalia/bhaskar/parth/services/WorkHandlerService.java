package com.kalia.bhaskar.parth.services;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;

import com.kalia.bhaskar.parth.activities.CommandsListActivity;
import com.kalia.bhaskar.parth.interfaces.WorkHandlerServiceInterface;
import com.kalia.bhaskar.parth.robo.InterpretedAction;
import com.kalia.bhaskar.parth.robo.Mappings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhaskar on 15/6/16.
 */
public class WorkHandlerService implements WorkHandlerServiceInterface {

    private SpeakerService speakerService;
    private DataService dataService;
    /*private Map<String, String> keywordToTextMap;*/

    public WorkHandlerService(){
        speakerService = new SpeakerService();
        dataService = new DataService();
        /*keywordToTextMap = new Mappings().getKeywordToTextMap();*/

        //remove this
    }

    /* methods for doing work */
    private void sleep(Context context){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private void showCommands(Context context){
        Intent i = new Intent(context, CommandsListActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
    /* //methods for doing work */



    @Override
    public void work(InterpretedAction ia, Context context, TextToSpeech textToSpeech) {
        //use cases for calling respective methods for work based upon keyword

        try{
            if(ia.getType().equals("speak")){
                /*speakerService.speak(keywordToTextMap.get(ia.getKeyword()),textToSpeech);*/
                //start here
                 speakerService.speak(dataService.getActionSpeechText(ia.getKeyword(),context),textToSpeech);
            }else{
                switch (ia.getKeyword()){
                    case "sleep":
                        sleep(context);
                        break;
                    case "show commands":
                        showCommands(context);
                        break;
                    default:
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            speakerService.speak("sorry I am dumb right now",textToSpeech);
        }

    }
}
