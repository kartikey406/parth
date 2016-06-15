package com.kalia.bhaskar.parth.services;

import android.content.Context;
import android.widget.Toast;

import com.kalia.bhaskar.parth.interfaces.InterpreterServiceInterface;
import com.kalia.bhaskar.parth.robo.InterpretedAction;
import com.kalia.bhaskar.parth.robo.Mappings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bhaskar on 14/6/16.
 */

/*
* this service interprets whatever user says
* and checks if such a keyword already exists in
* keyword mapping or not
* */

public class InterpreterService implements InterpreterServiceInterface{
    private Map<String,String> keyToTypeMap ;

    public InterpreterService(){
        keyToTypeMap = new Mappings().getKeyToTypeMap();
        //generateMap();
    }

    /*
    * TODO: <bhaskar.kalia>
    * In future generate this map from a file saved in directory so that robo
    * enables adding new keywords via app directly ()
    * */
    /*private void generateMap(){

        keyToTypeMap = new HashMap<String,String>();
        *//*
        * put all keywords mapped to their type {keyword:type}
        * *//*

        keyToTypeMap.put("what is your name","speak");
        keyToTypeMap.put("who is your owner","speak");
        keyToTypeMap.put("hello","speak");
        keyToTypeMap.put("sleep","work");

    }*/

    @Override
    public InterpretedAction interpret(String keyword, Context context){
        InterpretedAction ia = null;
        /*
        * code for identifying type of keyword (work or speak) based upon a map
        * */
        if(keyToTypeMap.get(keyword) != null){
            ia = new InterpretedAction(keyword,keyToTypeMap.get(keyword));
        }else {
            System.out.println(keyToTypeMap.get(keyword));
            return  null;
        }
        return  ia;
    }
}
